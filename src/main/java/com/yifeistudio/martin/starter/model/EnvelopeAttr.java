package com.yifeistudio.martin.starter.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 信封属性
 *
 * @author : hongyi
 * created at 2022/4/26 - 13:02
 **/
@AllArgsConstructor
public enum EnvelopeAttr {

    /**
     * 系统消息
     */
    SYSTEM(1),

    /**
     * 内容敏感
     */
    SENSITIVE(2),

    /**
     * 顺序消费
     */
    ORDERED(4);

    @Getter
    private final int code;

}

