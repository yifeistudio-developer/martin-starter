package com.yifeistudio.martin.starter;

/**
 * 数据存储器
 *
 * @author : hongyi
 * created at 2022/4/26 - 15:35
 **/
public interface DataRepository {

    /**
     * 创建
     */
    void insert();

    /**
     * 根据主键更新记录
     */
    void updateById();

}
