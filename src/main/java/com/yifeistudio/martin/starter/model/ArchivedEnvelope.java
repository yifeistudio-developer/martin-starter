package com.yifeistudio.martin.starter.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 归档标签
     */
    private String tags;

    /**
     * 归档大小
     */
    private Long size;

    /**
     * 归档数据
     */
    private byte[] data;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createAt;

}
