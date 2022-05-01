package com.yifeistudio.martin.starter.auto;

import com.yifeistudio.martin.starter.DataRepository;
import com.yifeistudio.martin.starter.config.MartinProperties;
import com.yifeistudio.martin.starter.model.StartMode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

import javax.annotation.Resource;

/**
 * 基本事件监听器
 *
 * @author : hongyi
 * created at 2022/4/27 - 10:22
 **/
@Slf4j
class MartinListener implements ApplicationListener<ApplicationPreparedEvent> {

    @Resource
    private MartinProperties properties;

    @Resource
    private DataRepository dataRepository;

    /**
     * 监听Spring上下文事件
     *
     * @param event the event to respond to
     */
    @Override
    public void onApplicationEvent(ApplicationPreparedEvent event) {
        StartMode mode = properties.getMode();
        if (mode == StartMode.INIT) {
            dataRepository.initDB();
        }
    }


}
