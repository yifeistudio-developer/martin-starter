package com.yifeistudio.martin.starter.vendor;

import com.yifeistudio.martin.starter.MessageChannel;
import com.yifeistudio.martin.starter.config.MartinProperties;
import com.yifeistudio.martin.starter.model.Envelope;
import com.yifeistudio.martin.starter.model.Message;
import com.yifeistudio.space.starter.config.SpringContextHelper;
import com.yifeistudio.space.unit.model.Result;
import com.yifeistudio.space.unit.model.Tuple;
import com.yifeistudio.space.unit.util.Asserts;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Rocket MQ 消息通道
 *
 * @author : hongyi
 * created at 2022/4/26 - 15:49
 **/
@Slf4j
public class RocketMqMessageChannel implements MessageChannel<SendResult> {

    private final MartinProperties properties;

    private RocketMQTemplate rocketMQTemplate;

    public RocketMqMessageChannel(MartinProperties properties) {
        this.properties = properties;
        SpringContextHelper.getBean(RocketMQTemplate.class).ifPresent(bean -> rocketMQTemplate = bean);
    }



    /**
     * 同步投递
     *
     * @param envelope 信件
     * @return 投递回执
     */
    @Override
    public Result<SendResult> post(Envelope envelope) {
        return post(Collections.singleton(envelope));
    }

    @Override
    public Result<SendResult> post(Collection<Envelope> envelopes) {

        if (rocketMQTemplate == null) {
            log.warn("cannot find the rocketMQTemplate instance in the spring context. post-request is ignored.");
            return (Result<SendResult>) Result.fail(-1, "cannot find the rocketMQTemplate instance in the spring context");
        }
        Asserts.notNull(envelopes, "envelope is required notNull");
        boolean anyEnvelopeIsNull = envelopes.stream().anyMatch(Objects::isNull);
        Asserts.isTrue(!anyEnvelopeIsNull, "contains null in collection");
        boolean anyTopicIsNull = envelopes.stream()
                .map(Envelope::getTopic)
                .anyMatch(Objects::isNull);
        Asserts.isTrue(!anyTopicIsNull, "contains null in collection");
        Map<Envelope, List<Tuple<String, Envelope>>> groupedEnvelopes = envelopes.stream()
                .map(envelope -> Tuple.of(String.format(envelope.getTopic(), envelope.getTags()), envelope))
                .collect(Collectors.groupingBy(Tuple::getR));
        // TODO: 2022/4/28 可以并行处理

        return Result.success(null);
    }

    /**
     * 异步投递
     *
     * @param envelope 信件
     * @return 发送回执
     */
    @Override
    public Result<SendResult> postAsync(Envelope envelope) {

        return null;
    }

    @Override
    public Result<SendResult> postAsync(Collection<Envelope> envelopes) {
        return null;
    }

    /**
     * 同步投递 - 消息
     *
     * @param message 消息
     * @return 投递回执
     */
    @Override
    public Result<SendResult> post(Message message) {

        return null;
    }

    /**
     * 异步投递-消息
     *
     * @param message 消息
     * @return 投递回执
     */
    @Override
    public Result<SendResult> postAsync(Message message) {

        return null;
    }

    /**
     * 信件抵达
     *
     * @param envelope 信件
     */
    @Override
    public void handleMessage(Envelope envelope) {

    }
}
