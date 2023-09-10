package com.yifeistudio.martin.starter.vendor;

import com.yifeistudio.martin.starter.EnvelopeRepository;
import com.yifeistudio.martin.starter.model.AbstractEnvelope;
import com.yifeistudio.martin.starter.model.EnvelopeStatusEnum;
import com.yifeistudio.space.starter.config.SpringContextHelper;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.List;

/**
 * mybatis
 *
 * @author : hongyi
 * created at 2022/4/26 - 19:31
 **/
public class DefaultEnvelopeRepository implements EnvelopeRepository {

    private DataSource dataSource;


    public DefaultEnvelopeRepository() {
        SpringContextHelper.getBean(DataSource.class)
                .ifPresent(ds -> dataSource = ds);
    }

    /**
     * 创建
     *
     * @param envelope 信件
     */
    @Override
    public void insert(AbstractEnvelope<?> envelope) {

    }

    /**
     * 根据主键更新记录
     *
     * @param envelope 信件
     */
    @Override
    public void updateById(AbstractEnvelope<?> envelope) {

    }

    @Override
    public <T> AbstractEnvelope<T> getById(long id) {
        return null;
    }

    @Override
    public <T> AbstractEnvelope<T> getBySign(String sign) {
        try {
            Connection connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
    public <T> List<AbstractEnvelope<T>> listByStatus(int limit, EnvelopeStatusEnum... status) {
        return null;
    }

    /**
     * 初始化数据库配置
     */
    @Override
    public void initDB() {
        try {
            Connection connection = dataSource.getConnection();
            DatabaseMetaData metaData = connection.getMetaData();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
