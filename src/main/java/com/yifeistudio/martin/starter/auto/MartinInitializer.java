package com.yifeistudio.martin.starter.auto;

import com.yifeistudio.martin.starter.config.MartinProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * File Description
 *
 * @author : hongyi
 * created at 2022/4/27 - 15:31
 **/
@EnableConfigurationProperties({MartinProperties.class})
@ConditionalOnProperty(prefix = "martin", name = "enable", matchIfMissing = true, havingValue = "true")
class MartinInitializer {

    private final MartinProperties martinProperties;

    public MartinInitializer(MartinProperties martinProperties) {
        this.martinProperties = martinProperties;
    }



}
