package com.yifeistudio.martin.starter.auto;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * 基本事件监听器
 *
 * @author : hongyi
 * created at 2022/4/27 - 10:22
 **/
@Slf4j
class MartinListener implements ApplicationListener<ApplicationEvent> {


    /**
     * 监听Spring上下文事件
     *
     * @param event the event to respond to
     */
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        log.info("application event happened");
    }


}
