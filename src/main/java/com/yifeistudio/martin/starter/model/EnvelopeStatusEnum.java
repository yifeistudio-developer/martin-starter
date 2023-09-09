package com.yifeistudio.martin.starter.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.yifeistudio.space.unit.SpaceException;
import com.yifeistudio.space.unit.model.Result;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * 信封状态
 *
 * @author : hongyi
 * created at 2022/4/26 - 13:02
 **/
@Getter
@AllArgsConstructor
public enum EnvelopeStatusEnum {

    /**
     * 就绪（默认）
     */
    READY(0, "就绪"),

    /**
     * 投递成功
     */
    POST_SUCCEED(1, "投递成功"),


    /**
     * 投递失败
     */
    POST_FAILED(-1, "投递失败"),

    /**
     * 签收成功
     */
    SIGN_SUCCEED(2, "签收成功"),

    /**
     * 签收失败
     */
    SIGN_FAILED(-2, "签收失败"),

    /**
     * 已死亡
     */
    DEAD(-3, "已死亡");

    @JsonValue
    private final int code;

    private final String desc;

    @JsonCreator
    public static EnvelopeStatusEnum of(int code) {
        return Arrays.stream(EnvelopeStatusEnum.values())
                .filter(v -> v.getCode() == code)
                .findAny()
                .orElseThrow(() -> new SpaceException(Result.fail(400, "未识别的编码")));
    }

}
