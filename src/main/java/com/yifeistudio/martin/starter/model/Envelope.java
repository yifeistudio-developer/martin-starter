package com.yifeistudio.martin.starter.model;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 信封
 *
 * @author : hongyi
 * created at 2022/4/26 - 13:00
 **/
@Data
public class Envelope {

    /**
     * ID
     */
    private Long id;

    /**
     * 信件类型
     */
    private EnvelopeType type;

    /**
     * 主题
     */
    private String topic;

    /**
     * 标签
     */
    private String tags;

    /**
     * 投递人ID
     */
    private Long postedBy;

    /**
     * 投递时间
     */
    private Long postedAt;

    /**
     * 签售人
     */
    private Long signedBy;

    /**
     * 签收时间
     */
    private Long signedAt;

    /**
     * 消息签名
     */
    private String sign;

    /**
     * 属性
     */
    private Integer attr;

    /**
     * 状态
     */
    private EnvelopeStatus status;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 最大年龄限制
     */
    private Integer maxAge;

    /**
     * 信件
     */
    private Message message;

    /**
     * 创建时间
     */
    private LocalDateTime createAt;

    /**
     * 最后更新时间
     */
    private LocalDateTime updateAt;
}
///～
