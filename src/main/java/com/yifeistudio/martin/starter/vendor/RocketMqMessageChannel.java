package com.yifeistudio.martin.starter.vendor;

import com.yifeistudio.martin.starter.MessageChannel;
import org.apache.rocketmq.spring.core.RocketMQTemplate;

/**
 * Rocket MQ 消息通道
 *
 * @author : hongyi
 * created at 2022/4/26 - 15:49
 **/
public class RocketMqMessageChannel implements MessageChannel {


    private RocketMQTemplate rocketMQTemplate = new RocketMQTemplate();

    @Override
    public void handleMessage() {

    }

}
