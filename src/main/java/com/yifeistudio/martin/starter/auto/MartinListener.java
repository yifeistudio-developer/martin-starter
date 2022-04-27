package com.yifeistudio.martin.starter.auto;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * 基本事件监听器
 *
 * @author : hongyi
 * created at 2022/4/27 - 10:22
 **/

class MartinListener implements ApplicationListener<ApplicationEvent> {


    /**
     * Handle an application event.
     *
     * @param event the event to respond to
     */
    @Override
    public void onApplicationEvent(ApplicationEvent event) {

    }
}
