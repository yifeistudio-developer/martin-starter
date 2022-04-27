package com.yifeistudio.martin.starter.auto;

import com.yifeistudio.martin.starter.Coordinator;
import com.yifeistudio.martin.starter.DataRepository;
import com.yifeistudio.martin.starter.MessageChannel;
import com.yifeistudio.martin.starter.config.MartinProperties;
import com.yifeistudio.martin.starter.vendor.DefaultCoordinator;
import com.yifeistudio.martin.starter.vendor.MybatisDataRepository;
import com.yifeistudio.martin.starter.vendor.RocketMqMessageChannel;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * 初始化配置
 *
 * @author : hongyi
 * created at 2022/4/27 - 15:31
 **/
@EnableConfigurationProperties({MartinProperties.class})
@ConditionalOnProperty(prefix = "martin", name = "enable", matchIfMissing = true, havingValue = "true")
class MartinInitializer {

    @ConditionalOnMissingBean(DataRepository.class)
    public DataRepository configDataRepository() {
        return new MybatisDataRepository();
    }

    @ConditionalOnMissingBean(MessageChannel.class)
    public MessageChannel configMessageChannel() {
        return new RocketMqMessageChannel();
    }

    @ConditionalOnMissingBean(Coordinator.class)
    public Coordinator configCoordinator() {
        return new DefaultCoordinator();
    }

}
