package com.rookie.im.netty.learing.netty.heartBeat.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoop;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.resolver.InetSocketAddressResolver;

import java.util.Random;

/**
 * @Author: Jokeer
 * @Description: TODO
 * @Date: 2024/5/17 22:26
 * @Version: 1.0
 */

public class HeartBeatClient{

    public static void main(String[] args) throws Exception {
        //池子
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();

        try {
            //创建bootstrap
            Bootstrap b = new Bootstrap();

            b.group(eventLoopGroup).channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast("decoder", new StringDecoder());
                            pipeline.addLast("encoder", new StringEncoder());
                            pipeline.addLast(new HeartBeatArtisanClientHandler());
                        }
                    });
            Channel channel = b.connect("127.0.0.1", 9000).sync().channel();
            String msg = "Heartbeat Packet";
            Random random = new Random();

            while(channel.isActive()){
                int i = random.nextInt(8);
                Thread.sleep(i * 1000);
                channel.writeAndFlush(msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            eventLoopGroup.shutdownGracefully();
        }


    }

}
