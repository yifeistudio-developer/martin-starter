package com.yifeistudio.martin.starter;

import com.yifeistudio.martin.starter.model.StartModeEnum;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 配置
 *
 * @author : hongyi
 * created at 2022/4/26 - 13:38
 **/
@Data
@ConfigurationProperties(prefix = "space.martin")
public class MartinProperties {

    /**
     * 是否启用
     */
    private boolean enable = true;

    /**
     * 启动模式
     */
    private StartModeEnum mode = StartModeEnum.INIT;


}
