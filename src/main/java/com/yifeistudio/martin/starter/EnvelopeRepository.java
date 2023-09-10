package com.yifeistudio.martin.starter;

import com.yifeistudio.martin.starter.model.AbstractEnvelope;
import com.yifeistudio.martin.starter.model.EnvelopeStatusEnum;

import java.util.List;

/**
 * 数据存储器
 *
 * @author : hongyi
 * created at 2022/4/26 - 15:35
 **/
public interface EnvelopeRepository {

    /**
     * 创建
     */
    void insert(AbstractEnvelope<?> envelope);

    /**
     * 根据主键更新记录
     */
    void updateById(AbstractEnvelope<?> envelope);

    <T> AbstractEnvelope<T> getById(long id);

    <T> AbstractEnvelope<T> getBySign(String sign);

    /**
     * 根据状态查询
     *
     * @param limit 限制数量
     * @param status 状态
     * @return 信件列表
     */
    <T> List<AbstractEnvelope<T>> listByStatus(int limit, EnvelopeStatusEnum... status);

    /**
     * 初始化数据库配置
     */
    void initDB();
}
