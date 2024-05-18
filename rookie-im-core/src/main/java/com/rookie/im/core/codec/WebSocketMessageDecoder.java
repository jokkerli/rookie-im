package com.rookie.im.core.codec;

import com.rookie.im.core.codec.proto.Message;
import com.rookie.im.core.codec.utils.ByteBufToMessageUtils;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;

import java.util.List;

/**
 * @Author: Jokeer
 * @Description: TODO
 * @Date: 2024/5/18 13:09
 * @Version: 1.0
 */

public class WebSocketMessageDecoder extends MessageToMessageDecoder<BinaryWebSocketFrame> {
    private static final int HEADER_LENGTH = 28;
    @Override
    protected void decode(ChannelHandlerContext ctx, BinaryWebSocketFrame msg, List<Object> out) throws Exception {
        ByteBuf content = msg.content();
        if (content.readableBytes() < HEADER_LENGTH) {
            return;
        }
        Message message = ByteBufToMessageUtils.transition(content);
        if(message == null){
            return;
        }
        out.add(message);
    }
}
