package com.yifeistudio.martin.starter.vendor;

import com.yifeistudio.martin.starter.DataRepository;
import com.yifeistudio.martin.starter.model.Envelope;
import com.yifeistudio.martin.starter.model.EnvelopeStatus;
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
public class DefaultRepository implements DataRepository {

    private DataSource dataSource;


    public DefaultRepository() {
        SpringContextHelper.getBean(DataSource.class)
                .ifPresent(ds -> dataSource = ds);
    }

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
    public List<Envelope> listByStatus(int limit, EnvelopeStatus... status) {

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
