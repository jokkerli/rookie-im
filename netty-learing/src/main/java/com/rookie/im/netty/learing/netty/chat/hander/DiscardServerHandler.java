package com.rookie.im.netty.learing.netty.chat.hander;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

import java.nio.channels.SocketChannel;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Jokeer
 * @Description: TODO
 * @Date: 2024/4/28 14:16
 * @Version: 1.0
 */

public class DiscardServerHandler extends ChannelInboundHandlerAdapter {


    private static Set<Channel> socketChannelSet = new HashSet<Channel>();

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        // 通知其他人，用户上线了
        socketChannelSet.forEach(e -> {
            e.writeAndFlush("[客户端]"+ctx.channel().remoteAddress() + "上线了");
        });

        socketChannelSet.add(ctx.channel());

    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        String data = (String) msg;

        socketChannelSet.forEach(e ->{
            if(e == ctx.channel()){
                e.writeAndFlush("[自己]：" + data);
            }else {
                e.writeAndFlush("[客户端]"+ctx.channel().remoteAddress() + " : " +data);
            }
        });
    }


    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        // 通知其他客户端，该用户下线了
        socketChannelSet.remove(ctx.channel());
        socketChannelSet.forEach(e -> {
            e.writeAndFlush("[客户端]"+ctx.channel().remoteAddress() + "下线了");
        });
    }
}
