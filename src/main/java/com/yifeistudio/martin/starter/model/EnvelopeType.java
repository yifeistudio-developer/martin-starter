package com.yifeistudio.martin.starter.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 信件类型
 *
 * @author : hongyi
 * created at 2022/4/27 - 19:17
 **/
@AllArgsConstructor
public enum EnvelopeType {

    /**
     * 发件
     */
    OUTBOX(0),

    /**
     * 收件
     */
    INBOX(1);

    @Getter
    private final int code;

}
