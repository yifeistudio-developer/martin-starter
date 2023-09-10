package com.yifeistudio.martin.starter.auto;

import com.yifeistudio.martin.starter.Coordinator;
import com.yifeistudio.martin.starter.EnvelopeRepository;
import com.yifeistudio.martin.starter.Channel;
import com.yifeistudio.martin.starter.MartinProperties;
import com.yifeistudio.martin.starter.vendor.DefaultCoordinator;
import com.yifeistudio.martin.starter.vendor.DefaultEnvelopeRepository;
import com.yifeistudio.martin.starter.vendor.RocketMqChannel;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;


/**
 * 初始化配置
 *
 * @author : hongyi
 * created at 2022/4/27 - 15:31
 **/
@EnableConfigurationProperties({MartinProperties.class})
@ConditionalOnProperty(prefix = "martin",
        name = "enable",
        matchIfMissing = true,
        havingValue = "true")
class MartinInitializer {

    @Autowired
    public MartinInitializer(MartinProperties properties) {

    }

    @Bean
    @ConditionalOnBean(DataSource.class)
    @ConditionalOnMissingBean(EnvelopeRepository.class)
    public EnvelopeRepository configDataRepository() {
        return new DefaultEnvelopeRepository();
    }

    @Bean
    @ConditionalOnBean(RocketMQTemplate.class)
    @ConditionalOnMissingBean(Channel.class)
    public Channel configMessageChannel() {
        return new RocketMqChannel();
    }

    @Bean
    @ConditionalOnMissingBean(Coordinator.class)
    public Coordinator configCoordinator() {
        return new DefaultCoordinator();
    }

}
