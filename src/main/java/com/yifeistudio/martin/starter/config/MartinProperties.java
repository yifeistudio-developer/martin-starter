package com.yifeistudio.martin.starter.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

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
    private Producer producer;

    /**
     * 消费者
     */
    private Consumer consumer;

    /**
     * 生产者
     */
    @Data
    public static class Producer {

        /**
         * 生产组名
         */
        private String group;

        /**
         * 主题
         */
        private String topic;

        /**
         * 标签
         */
        private String tags;

    }


    /**
     * 消费者
     */
    @Data
    public static class Consumer {

        /**
         * 消费组名
         */
        private String group;

        /**
         * 主题-标签
         */
        private Map<String, String> topicTags;

    }

}
