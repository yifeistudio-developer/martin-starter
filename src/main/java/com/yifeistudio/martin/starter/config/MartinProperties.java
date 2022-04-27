package com.yifeistudio.martin.starter.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 配置
 *
 * @author : hongyi
 * created at 2022/4/26 - 13:38
 **/
@Data
@ConfigurationProperties(prefix = "martin")
public class MartinProperties {

    /**
     * 是否启用
     */
    private boolean enable = true;

    /**
     * 生产者
     */
    @Data
    public static class Producer {

    }


    /**
     * 消费者
     */
    @Data
    public static class Consumer {

        private String topic;

        private String tags;

    }

}
