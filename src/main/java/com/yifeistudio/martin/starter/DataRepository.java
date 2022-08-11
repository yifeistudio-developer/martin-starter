package com.yifeistudio.martin.starter;

import com.yifeistudio.martin.starter.model.Envelope;
import com.yifeistudio.martin.starter.model.EnvelopeStatus;

import java.util.List;

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
    void insert(Envelope envelope);

    /**
     * 根据主键更新记录
     */
    void updateById(Envelope envelope);

    Envelope getById(long id);

    Envelope getBySign(String sign);

    /**
     * 根据状态查询
     *
     * @param limit 限制数量
     * @param status 状态
     * @return 信件列表
     */
    List<Envelope> listByStatus(int limit, EnvelopeStatus... status);

    /**
     * 初始化数据库配置
     */
    void initDB();
}
