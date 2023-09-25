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

    /**
     * 根据ID获取消息
     * @param id 消息ID
     * @return 指定消息
     * @param <T> 消息类型
     */
    <T, E extends AbstractEnvelope<T>> E  getById(long id);

    <T, E extends AbstractEnvelope<T>> E getBySign(String sign);

    /**
     * 根据状态查询
     *
     * @param limit 限制数量
     * @param status 状态
     * @return 信件列表
     */
    <T, E extends AbstractEnvelope<T>> List<E> listByStatus(int limit, EnvelopeStatusEnum... status);

    /**
     * 初始化数据库配置
     */
    void initDB();
}
