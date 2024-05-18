package com.rookie.im.core.codec.proto;

import lombok.Data;

/**
 * @Author: Jokeer
 * @Description: TODO
 * @Date: 2024/5/18 13:13
 * @Version: 1.0
 */
@Data
public class Message {

    private MessageHeader messageHeader;

    private Object messagePack;

    @Override
    public String toString() {
        return "Message{" +
                "messageHeader=" + messageHeader +
                ", messagePack=" + messagePack +
                '}';
    }
}
