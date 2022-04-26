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
     * 内容涉密
     */
    SENSITIVE(1);

    @Getter
    private final int code;

}

