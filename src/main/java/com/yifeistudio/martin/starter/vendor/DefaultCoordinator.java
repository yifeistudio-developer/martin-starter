package com.yifeistudio.martin.starter.vendor;

import com.yifeistudio.martin.starter.Coordinator;

import java.util.concurrent.TimeUnit;

/**
 * 默认协调器
 *
 * @author : hongyi
 * created at 2022/4/27 - 16:19
 **/
public class DefaultCoordinator implements Coordinator {


    /**
     * 自增序号
     *
     * @return 自增序号
     */
    @Override
    public long incrAndGetSeq() {
        return 0;
    }

    /**
     * 获取排他锁
     *
     * @param key 锁键
     * @return 是否锁定成功
     */
    @Override
    public boolean tryLock(String key) {
        return false;
    }

    /**
     * 获取排他锁
     *
     * @param key      锁键
     * @param timeout  超时时间
     * @param timeUnit 超时单位
     * @return 是否锁定成功
     */
    @Override
    public boolean tryLock(String key, long timeout, TimeUnit timeUnit) {


        return false;
    }
}
