package com.yifeistudio.martin.starter.vendor;

import com.yifeistudio.martin.starter.MessageChannel;
import com.yifeistudio.martin.starter.config.MartinProperties;
import com.yifeistudio.martin.starter.model.Envelope;
import com.yifeistudio.martin.starter.model.Message;
import com.yifeistudio.space.starter.config.SpringContextHelper;
import com.yifeistudio.space.unit.model.Result;
import com.yifeistudio.space.unit.model.Tuple;
import com.yifeistudio.space.unit.util.Asserts;
import io.netty.util.concurrent.Promise;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.util.StringUtils;

/**
 * Rocket MQ 消息通道
 *
 * @author : hongyi
 * created at 2022/4/26 - 15:49
 **/
@Slf4j
public class RocketMqMessageChannel implements MessageChannel {

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
    public Result<String> post(Envelope envelope) {
        Tuple<String, org.springframework.messaging.Message<Envelope>> messageTuple = wrapMqMessage(envelope);
        if (messageTuple == null) {
            return Result.fail(-1, "");
        }
        SendResult sendResult = rocketMQTemplate.syncSend(messageTuple.getLeft(), messageTuple.getRight());
        boolean isOk = sendResult.getSendStatus() == SendStatus.SEND_OK;
        return new Result<>(isOk ? 0 : -1, sendResult.getMsgId());
    }


    /**
     * 异步投递
     *
     * @param envelope 信件
     * @return 发送回执
     */
    @Override
    public Promise<Result<String>> postAsync(Envelope envelope) {
        Tuple<String, org.springframework.messaging.Message<Envelope>> messageTuple = wrapMqMessage(envelope);
        if (messageTuple == null) {
            // FIXME: 2022/4/29
//            return Result.fail(-1, "");
            return null;
        }

        rocketMQTemplate.asyncSend(messageTuple.getLeft(), messageTuple.getRight(), new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {

            }

            @Override
            public void onException(Throwable e) {

            }
        });

        // FIXME: 2022/4/29 Promise
        return null;
    }


    /**
     * 同步投递 - 消息
     *
     * @param message 消息
     * @return 投递回执
     */
    @Override
    public Result<String> post(Message message) {

        return null;
    }

    /**
     * 异步投递-消息
     *
     * @param message 消息
     * @return 投递回执
     */
    @Override
    public Promise<Result<String>> postAsync(Message message) {

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

    /**
     * 组装发送mq 消息结构
     *
     * @param envelope 信件
     * @return destination -> message.
     */
    private Tuple<String, org.springframework.messaging.Message<Envelope>> wrapMqMessage(Envelope envelope) {
        if (rocketMQTemplate == null) {
            log.warn("cannot find the rocketMQTemplate instance in the spring context. post-request is ignored.");
            return null;
        }
        Asserts.notNull(envelope, "envelope is required nonNull");
        String topic = envelope.getTopic();
        String tags = envelope.getTags();
        if (topic == null) {
            MartinProperties.Producer producer = properties.getProducer();
            topic = producer.getTopic();
            tags = producer.getTags();
        }
        Asserts.notNull(topic, "cannot find any available");
        String destination = topic.trim();
        if (StringUtils.hasText(tags)) {
            destination = destination + ":" + tags;
        }
        org.springframework.messaging.Message<Envelope> message = MessageBuilder.withPayload(envelope).build();
        return Tuple.of(destination, message);
    }
}
