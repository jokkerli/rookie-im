package com.rookie.im.netty.learing.io;

import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @Author: Jokeer
 * @Description: TODO
 * @Date: 2024/4/28 9:14
 * @Version: 1.0
 */

public class NIOLearning {

    public static void main(String[] args) {

//        SocketChannel
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            Integer next = iterator.next();
            System.out.println(next);
            iterator.remove();
        }


        System.out.println(list);
    }

}
