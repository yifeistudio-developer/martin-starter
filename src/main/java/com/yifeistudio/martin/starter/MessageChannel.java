package com.yifeistudio.martin.starter;

import com.yifeistudio.martin.starter.model.Envelope;
import com.yifeistudio.space.unit.model.Promise;
import com.yifeistudio.space.unit.model.Result;


/**
 * 消息通道
 *
 * @author : hongyi
 * created at 2022/4/26 - 15:43
 **/
public interface MessageChannel {

    /**
     * 同步投递
     *
     * @param envelope 信件
     * @return 投递回执
     */
    Result<String> post(Envelope envelope);


    /**
     * 异步投递
     *
     * @param envelope 信件
     * @return 投递回执
     */
    Promise<Result<String>> postAsync(Envelope envelope);

    /**
     * 同步投递 - 消息
     *
     * @param message 消息
     * @return 投递回执
     */
    Result<String> post(Object message);

    /**
     * 异步投递-消息
     *
     * @param message 消息
     * @return 投递回执
     */
    Promise<Result<String>> postAsync(Object message);

    /**
     * 信件抵达
     *
     * @param envelope 信件
     */
    void handleMessage(Envelope envelope);

}
