package com.yifeistudio.martin.starter.vendor;

import com.yifeistudio.martin.starter.EnvelopeRepository;
import com.yifeistudio.martin.starter.Scheduler;

import javax.annotation.Resource;

/**
 * 文件描述
 *
 * @author yi
 * <p>
 * Created at 2023/9/25 下午2:10
 * @since 1.0
 */
public class DefaultScheduler implements Scheduler {

    @Resource
    private EnvelopeRepository envelopeRepository;

    @Override
    public void tryPost() {

    }

    @Override
    public void trySign() {

    }

    @Override
    public void doArchive() {

    }
}
