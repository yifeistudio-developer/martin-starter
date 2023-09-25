package com.yifeistudio.martin.starter.auto;

import com.yifeistudio.martin.starter.*;
import com.yifeistudio.martin.starter.vendor.DefaultCoordinator;
import com.yifeistudio.martin.starter.vendor.DefaultEnvelopeRepository;
import com.yifeistudio.martin.starter.vendor.DefaultScheduler;
import com.yifeistudio.martin.starter.vendor.RocketMqMqChannel;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;


/**
 * 初始化配置
 *
 * @author : hongyi
 * created at 2022/4/27 - 15:31
 **/
@AutoConfiguration
@EnableConfigurationProperties({MartinProperties.class})
class MartinInitializer {

    /**
     * 数据园
     * @return 数据源
     */
    @Bean
    @ConditionalOnBean(DataSource.class)
    @ConditionalOnMissingBean(EnvelopeRepository.class)
    public EnvelopeRepository configDataRepository() {
        return new DefaultEnvelopeRepository();
    }

    /**
     * 消息通道
     * @return 消息通道
     */
    @Bean
    @ConditionalOnBean(RocketMQTemplate.class)
    @ConditionalOnMissingBean(MqChannel.class)
    public MqChannel configMessageChannel() {
        return new RocketMqMqChannel();
    }

    /**
     * 协调器
     * @return 协调器
     */
    @Bean
    @ConditionalOnMissingBean(Coordinator.class)
    public Coordinator configCoordinator() {
        return new DefaultCoordinator();
    }

    @Bean
    @ConditionalOnBean(EnvelopeRepository.class)
    public Scheduler configScheduler() {
        return new DefaultScheduler();
    }

}
///～