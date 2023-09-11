package com.yifeistudio.martin.starter.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 信封
 *
 * @author : hongyi
 * created at 2022/4/26 - 13:00
 **/
@Data
@TableName(value = "t_envelope", autoResultMap = true)
public abstract class AbstractEnvelope<T>{

    public abstract void setMessage(T message);

    public abstract T getMessage();

    /**
     * ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 信件类型
     */
    private EnvelopeTypeEnum type;

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
    private EnvelopeStatusEnum status;

    /**
     * 年龄
     */
    private Integer age;

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
