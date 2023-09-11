package com.yifeistudio.martin.starter.model;

/**
 * 文件描述
 *
 * @author yi
 * <p>
 * Created at 2023/9/9 下午3:45
 * @since 1.0
 */
public class TextEnvelope extends AbstractEnvelope<TextMessage> {


    private TextMessage message;

    @Override
    public void setMessage(TextMessage message) {

    }

    @Override
    public TextMessage getMessage() {
        return this.message;
    }

}
