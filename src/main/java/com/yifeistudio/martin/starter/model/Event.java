package com.yifeistudio.martin.starter.model;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 事件-不可变
 *
 * @author : hongyi
 * created at 2022/4/26 - 13:14
 **/
@Data
public class Event {

    /**
     * ID
     */
    private Long id;

    /**
     * 创建时间
     */
    private LocalDateTime createAt;

}
///~