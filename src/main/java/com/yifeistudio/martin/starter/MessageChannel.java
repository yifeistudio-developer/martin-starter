package com.yifeistudio.martin.starter;

import com.yifeistudio.martin.starter.model.Envelope;
import com.yifeistudio.martin.starter.model.Message;
import com.yifeistudio.space.unit.model.Result;

import java.util.Collection;

/**
 * 消息通道
 *
 * @author : hongyi
 * created at 2022/4/26 - 15:43
 **/
public interface MessageChannel<T> {

    /**
     * 同步投递
     *
     * @param envelope 信件
     * @return 投递回执
     */
    Result<T> post(Envelope envelope);

    Result<T> post(Collection<Envelope> envelopes);

    /**
     * 异步投递
     *
     * @param envelope 信件
     * @return 投递回执
     */
    Result<T> postAsync(Envelope envelope);

    Result<T> postAsync(Collection<Envelope> envelopes);

    /**
     * 同步投递 - 消息
     *
     * @param message 消息
     * @return 投递回执
     */
    Result<T> post(Message message);

    /**
     * 异步投递-消息
     *
     * @param message 消息
     * @return 投递回执
     */
    Result<T> postAsync(Message message);

    /**
     * 信件抵达
     *
     * @param envelope 信件
     */
    void handleMessage(Envelope envelope);

}
