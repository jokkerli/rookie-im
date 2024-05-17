package com.rookie.im.netty.learing.netty.heartBeat.server;

/**
 * @Author: Jokeer
 * @Description: TODO
 * @Date: 2024/4/28 14:11
 * @Version: 1.0
 */

import com.rookie.im.netty.learing.netty.heartBeat.hander.HeartBeatHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.timeout.IdleStateHandler;

public class DiscardServer {

    private int port;

    public DiscardServer(int port){
        this.port = port;
    }


    public void run() throws Exception {
        EventLoopGroup bossGroup = new NioEventLoopGroup(1); // (1)线程池
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap(); // (2)
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class) // (3)
                    .childHandler(new ChannelInitializer<SocketChannel>() { // (4)
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new StringDecoder());
                            ch.pipeline().addLast(new StringEncoder());
                            ch.pipeline().addLast(new IdleStateHandler(3,0,0));
                            ch.pipeline().addLast(new HeartBeatHandler());
//                            ch.pipeline().addLast(new DiscardServerHandler());
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