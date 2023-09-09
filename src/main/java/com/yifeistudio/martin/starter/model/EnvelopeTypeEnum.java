package com.yifeistudio.martin.starter.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.yifeistudio.space.unit.SpaceException;
import com.yifeistudio.space.unit.model.Result;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * 信件类型
 *
 * @author : hongyi
 * created at 2022/4/27 - 19:17
 **/
@Getter
@AllArgsConstructor
public enum EnvelopeTypeEnum {

    /**
     * 发件
     */
    OUTBOX(0, "发件"),

    /**
     * 收件
     */
    INBOX(1, "收件");

    @JsonValue
    private final int code;

    private final String desc;

    @JsonCreator
    public static EnvelopeTypeEnum of(int code) {
        return Arrays.stream(EnvelopeTypeEnum.values())
                .filter(v -> v.code == code)
                .findAny()
                .orElseThrow(() -> new SpaceException(Result.fail(400, "未识别的编码")));
    }

}
