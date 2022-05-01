package com.yifeistudio.martin.starter;

import java.util.concurrent.TimeUnit;

/**
 * 协调器
 *
 * @author : hongyi
 * created at 2022/4/26 - 15:19
 **/
public interface Coordinator {

    /**
     * 自增序号
     *
     * @return 自增序号
     */
    long incrAndGetSeq();

    /**
     * 获取排他锁
     *
     * @param key 锁键
     * @return 是否锁定成功
     */
    boolean tryLock(String key);

    /**
     * 获取排他锁
     *
     * @param key 锁键
     * @param timeout 超时时间
     * @param timeUnit 超时单位
     * @return 是否锁定成功
     */
    boolean tryLock(String key, long timeout, TimeUnit timeUnit);

}
