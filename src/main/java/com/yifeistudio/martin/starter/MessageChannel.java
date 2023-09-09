package com.yifeistudio.martin.starter;

import com.yifeistudio.martin.starter.model.AbstractEnvelope;
import com.yifeistudio.space.unit.model.Promise;

import java.util.Optional;


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
    Optional<String> post(AbstractEnvelope envelope);


    /**
     * 异步投递
     *
     * @param envelope 信件
     * @return 投递回执
     */
    Promise<Optional<String>> postAsync(AbstractEnvelope envelope);

}
