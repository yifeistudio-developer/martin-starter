package com.yifeistudio.martin.starter.vendor;

import com.yifeistudio.martin.starter.MqChannel;
import com.yifeistudio.martin.starter.model.AbstractEnvelope;
import com.yifeistudio.space.starter.config.SpringContextHelper;
import com.yifeistudio.space.unit.model.DefaultPromise;
import com.yifeistudio.space.unit.model.Promise;
import com.yifeistudio.space.unit.util.Asserts;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;

import java.util.Optional;

/**
 * Rocket MQ 消息通道
 *
 * @author : hongyi
 * created at 2022/4/26 - 15:49
 **/
@Slf4j
public class RocketMqMqChannel implements MqChannel {

    private RocketMQTemplate rocketMQTemplate;

    public RocketMqMqChannel() {
        SpringContextHelper.getBean(RocketMQTemplate.class).ifPresent(bean -> rocketMQTemplate = bean);
    }


    /**
     * 同步投递
     *
     * @param envelope 信件
     * @return 投递回执
     */
    @Override
    public Optional<String> post(AbstractEnvelope<?> envelope) {
        if (rocketMQTemplate == null) {
            log.warn("cannot find the rocketMQTemplate instance in the spring context. post-request is ignored.");
            return Optional.empty();
        }
        Asserts.notNull(envelope, "envelope is required nonNull.");
        Asserts.notNull(envelope.getMessage(), "message is required nonNull.");
        Asserts.notNull(envelope.getSign(), "sign is required nonNull.");
        return Optional.empty();
    }


    /**
     * 异步投递
     *
     * @param envelope 信件
     * @return 发送回执
     */
    @Override
    public Promise<Optional<String>> postAsync(AbstractEnvelope<?> envelope) {
        return DefaultPromise.of(() -> post(envelope));
    }

}
