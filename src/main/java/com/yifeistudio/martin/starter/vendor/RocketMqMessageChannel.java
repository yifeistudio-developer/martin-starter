package com.yifeistudio.martin.starter.vendor;

import com.yifeistudio.martin.starter.MessageChannel;
import com.yifeistudio.martin.starter.config.MartinProperties;
import com.yifeistudio.martin.starter.model.Envelope;
import com.yifeistudio.martin.starter.model.Message;
import com.yifeistudio.space.unit.model.Result;
import org.apache.rocketmq.spring.core.RocketMQTemplate;

/**
 * Rocket MQ 消息通道
 *
 * @author : hongyi
 * created at 2022/4/26 - 15:49
 **/
public class RocketMqMessageChannel implements MessageChannel {

    private final MartinProperties properties;

    private RocketMQTemplate rocketMQTemplate;

    public RocketMqMessageChannel(MartinProperties properties) {
        this.properties = properties;
    }



    /**
     * 同步投递
     *
     * @param envelope 信件
     * @return 发送回执
     */
    @Override
    public <T> Result<T> post(Envelope envelope) {

        return null;
    }

    /**
     * 异步投递
     *
     * @param envelope 信件
     * @return 发送回执
     */
    @Override
    public <T> Result<T> postAsync(Envelope envelope) {

        return null;
    }

    /**
     * 同步投递 - 消息
     *
     * @param message 消息
     * @return 投递回执
     */
    @Override
    public <T> Result<T> post(Message message) {

        return null;
    }

    /**
     * 异步投递-消息
     *
     * @param message 消息
     * @return 投递回执
     */
    @Override
    public <T> Result<T> postAsync(Message message) {

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
