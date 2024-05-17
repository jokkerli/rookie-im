package com.rookie.im.netty.learing.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: Jokeer
 * @Description: TODO
 * @Date: 2024/4/28 8:42
 * @Version: 1.0
 */

public class BIOLearing {


    public static void main(String[] args) throws IOException {

        //1.创建一个serverSocker监听9000端口
        ServerSocket serverSocket = new ServerSocket(9000);

        System.out.println("服务器已启动，等待来凝结");

        while(true){
            Socket clientSocket = serverSocket.accept();
            System.out.println("有客户端连接，地址：" + clientSocket.getInetAddress().toString());

            new Thread(() -> {
                try {
                    InputStream inputStream = clientSocket.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    PrintWriter printWriter = new PrintWriter(clientSocket.getOutputStream(), true);
                    String request,respone;

                    while((request = bufferedReader.readLine()) != null){
                        System.out.println("收到消息" + request);

                        respone  = "已收到消息" + request;

                        printWriter.write(respone);
                    }


                } catch (IOException e) {
                    e.printStackTrace();
                }



            }).start();


        }


    }

}
