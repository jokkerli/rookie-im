package com.rookie.im.netty.learing.netty.chat.server;

/**
 * @Author: Jokeer
 * @Description: TODO
 * @Date: 2024/4/28 14:11
 * @Version: 1.0
 */

import com.rookie.im.netty.learing.netty.chat.hander.DiscardServerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

public class DiscardServer {

    private int port;

    public  DiscardServer(int port){
        this.port = port;
    }


    public static void main(String[] args) throws Exception {
        EventLoopGroup bossGroup = new NioEventLoopGroup(1); // (1)线程池
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap(); // (2)
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class) // (3)
                    .childHandler(new ChannelInitializer<SocketChannel>() { // (4)
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE,
                            0,1,0,4));
//                            ch.pipeline().addLast(new StringDecoder());
//                            ch.pipeline().addLast(new StringEncoder());
                            ch.pipeline().addLast(new DiscardServerHandler());
                        }
                    })
                    .option(ChannelOption.SO_BACKLOG, 128)          // (6)
                    .childOption(ChannelOption.SO_KEEPALIVE, true); // (7)

            // 绑定端口，开始接收进来的连接
            ChannelFuture f = b.bind(9000).sync(); // (8)
            System.out.println("TCP 启动成功！");
            // 等待服务器 socket 关闭。
            f.channel().closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }
}