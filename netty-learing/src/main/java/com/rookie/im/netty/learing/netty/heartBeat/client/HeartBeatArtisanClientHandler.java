package com.rookie.im.netty.learing.netty.heartBeat.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @Author: Jokeer
 * @Description: TODO
 * @Date: 2024/5/17 22:32
 * @Version: 1.0
 */

public class HeartBeatArtisanClientHandler extends SimpleChannelInboundHandler<String> {
    // 重写channelRead0方法以处理接收到的消息
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        // 打印出接收到的消息
        System.out.println(" client received :" + msg);
        // 如果接收到的消息是"idle close"，则关闭连接
        if (msg != null && msg.equals("idle close")) {
            // 打印出服务端关闭连接的信息
            System.out.println(" 服务端关闭连接，客户端也关闭");
            // 关闭客户端连接
            ctx.channel().closeFuture();
        }
    }
}