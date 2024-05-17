package com.rookie.im.netty.learing.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.TimeUnit;

public class NIOClient {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        SocketChannel socketChannel = null;
        try {
            socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
            socketChannel.connect(new InetSocketAddress("localhost", 9000));

            if (socketChannel.finishConnect()) {
                int i = 0;
                while (true) {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                        String info = "I'm " + i++ + "-th information from client";
                        buffer.clear();
                        buffer.put(info.getBytes());
                        buffer.flip();
                        while (buffer.hasRemaining()) {
                            socketChannel.write(buffer);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (socketChannel != null) {
                    socketChannel.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}