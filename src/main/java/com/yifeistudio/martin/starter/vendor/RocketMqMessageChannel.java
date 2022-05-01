package com.yifeistudio.martin.starter.vendor;

import com.yifeistudio.martin.starter.MessageChannel;
import com.yifeistudio.martin.starter.config.MartinProperties;
import com.yifeistudio.martin.starter.model.Envelope;
import com.yifeistudio.space.starter.config.SpringContextHelper;
import com.yifeistudio.space.unit.model.DefaultPromise;
import com.yifeistudio.space.unit.model.Promise;
import com.yifeistudio.space.unit.model.Result;
import com.yifeistudio.space.unit.model.Tuple;
import com.yifeistudio.space.unit.util.Asserts;
import com.yifeistudio.space.unit.util.Jsons;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultLitePullConsumer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

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
        try {
            tryInit();
        } catch (Throwable e) {
            // ignore the error
            log.error("init RocketMqMessageChannel failed. - ", e);
        }
    }

    /**
     * 初始化
     */
    private void tryInit() {
        // init consumer
        MartinProperties.Consumer consumer = properties.getConsumer();
        Map<String, String> topicTags = Optional.ofNullable(consumer)
                .map(MartinProperties.Consumer::getTopicTags)
                .orElse(Collections.emptyMap());
        if (topicTags.isEmpty()) {
            log.warn("cannot find any consumer information. init is skipped.");
            return;
        }
        DefaultLitePullConsumer defaultConsumer = rocketMQTemplate.getConsumer();
        if (defaultConsumer == null) {
            log.warn("cannot get consumer instance from template. The default consumer will be created.");
            defaultConsumer = new DefaultLitePullConsumer();
            rocketMQTemplate.setConsumer(defaultConsumer);
        }

//        rocketMQTemplate.getConsumer();

        // init producer.



    }


    /**
     * 同步投递
     *
     * @param envelope 信件
     * @return 投递回执
     */
    @Override
    public Result<String> post(Envelope envelope) {
        if (rocketMQTemplate == null) {
            log.warn("cannot find the rocketMQTemplate instance in the spring context. post-request is ignored.");
            return Result.fail(-1, "cannot find the rocketMQTemplate instance in the spring context.");
        }
        Asserts.notNull(envelope, "envelope is required nonNull.");
        Asserts.notNull(envelope.getMessage(), "message is required nonNull.");
        Asserts.notNull(envelope.getSign(), "sign is required nonNull.");
        String topic = envelope.getTopic();
        String tags = envelope.getTags();
        if (topic == null) {
            MartinProperties.Producer producer = properties.getProducer();
            topic = producer.getTopic();
            tags = producer.getTags();
        }
        Asserts.notNull(topic, "cannot find any available.");
        String destination = topic.trim();
        if (StringUtils.hasText(tags)) {
            destination = destination + ":" + tags;
        }
        Message<String> message = MessageBuilder.withPayload(envelope.getMessage())
                .setHeader("envelope-sign", envelope.getSign())
                .build();
        SendResult sendResult = rocketMQTemplate.syncSend(destination, message);
        boolean isOk = sendResult.getSendStatus() == SendStatus.SEND_OK;
        return isOk ? Result.success(sendResult.getMsgId()) : Result.fail(-1, "send message failed.");
    }


    /**
     * 异步投递
     *
     * @param envelope 信件
     * @return 发送回执
     */
    @Override
    public Promise<Result<String>> postAsync(Envelope envelope) {
        return DefaultPromise.of(() -> post(envelope));
    }


    /**
     * 同步投递 - 消息
     *
     * @param message 消息
     * @return 投递回执
     */
    @Override
    public Result<String> post(Object message) {
        Optional<String> jsonStr = Jsons.stringify(message);
        Asserts.isTrue(jsonStr.isPresent(), "message stringify failed.");
        Envelope envelope = new Envelope();
        envelope.setMessage(jsonStr.get());
        return post(envelope);
    }

    /**
     * 异步投递-消息
     *
     * @param message 消息
     * @return 投递回执
     */
    @Override
    public Promise<Result<String>> postAsync(Object message) {
        return DefaultPromise.of(() -> post(message));
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
