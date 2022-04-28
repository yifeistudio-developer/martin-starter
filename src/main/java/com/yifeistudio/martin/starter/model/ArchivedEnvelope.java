package com.yifeistudio.martin.starter.model;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 归档信件
 *
 * @author : hongyi
 * created at 2022/4/28 - 09:57
 **/
@Data
public class ArchivedEnvelope {

    /**
     * ID
     */
    private Long id;

    /**
     * 归档标签
     */
    private Integer tags;

    /**
     * 归档大小
     */
    private Integer size;

    /**
     * 创建时间
     */
    private LocalDateTime createAt;

    /**
     * 归档数据
     */
    private byte[] data;
}
