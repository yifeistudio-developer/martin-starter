package com.yifeistudio.martin.starter.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.yifeistudio.space.unit.SpaceException;
import com.yifeistudio.space.unit.model.Result;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * 信封属性
 *
 * @author : hongyi
 * created at 2022/4/26 - 13:02
 **/
@Getter
@AllArgsConstructor
public enum EnvelopeAttrEnum {

    /**
     * 系统消息
     */
    SYSTEM(1, "系统消息"),

    /**
     * 内容敏感
     */
    SENSITIVE(2, "内容敏感"),

    /**
     * 顺序消费
     */
    ORDERED(4, "顺序消费");

    @JsonValue
    private final int code;

    private final String desc;

    @JsonCreator
    public static EnvelopeAttrEnum of(int code) {
        return Arrays.stream(EnvelopeAttrEnum.values())
                .filter(v -> v.getCode() == code)
                .findAny()
                .orElseThrow(() -> new SpaceException(Result.fail(400, "未识别的编码")));
    }

}
///～
