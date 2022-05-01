package com.yifeistudio.martin.starter.vendor;

import com.yifeistudio.martin.starter.DataRepository;
import com.yifeistudio.martin.starter.model.Envelope;
import com.yifeistudio.martin.starter.model.EnvelopeStatus;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;

/**
 * mybatis
 *
 * @author : hongyi
 * created at 2022/4/26 - 19:31
 **/
public class MybatisDataRepository implements DataRepository {

    @Resource
    private DataSource dataSource;

    /**
     * 创建
     *
     * @param envelope 信件
     */
    @Override
    public void insert(Envelope envelope) {

    }

    /**
     * 根据主键更新记录
     *
     * @param envelope 信件
     */
    @Override
    public void updateById(Envelope envelope) {

    }

    @Override
    public Envelope getById(long id) {
        return null;
    }

    @Override
    public Envelope getBySign(String sign) {
        return null;
    }

    /**
     * 根据状态查询
     *
     * @param limit  限制数量
     * @param status 状态
     * @return 信件列表
     */
    @Override
    public List<Envelope> listByStatus(int limit, EnvelopeStatus... status) {


        return null;
    }

    /**
     * 初始化数据库配置
     */
    @Override
    public void initDB() {

    }


}
