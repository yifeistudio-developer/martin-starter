package com.yifeistudio.martin.starter.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 信封状态
 *
 * @author : hongyi
 * created at 2022/4/26 - 13:02
 **/
@AllArgsConstructor
public enum EnvelopeStatus {

    /**
     * 就绪（默认）
     */
    READY(0),

    /**
     * 投递成功
     */
    POST_SUCCEED(1),


    /**
     * 投递失败
     */
    POST_FAILED(-1),

    /**
     * 签收成功
     */
    SIGN_SUCCEED(2),

    /**
     * 签收失败
     */
    SIGN_FAILED(-2),

    /**
     * 已死亡
     */
    DEAD(-3);

    @Getter
    private final int code;

}
