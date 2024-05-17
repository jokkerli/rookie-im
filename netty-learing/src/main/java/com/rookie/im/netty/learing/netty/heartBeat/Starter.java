package com.rookie.im.netty.learing.netty.heartBeat;

import com.rookie.im.netty.learing.netty.heartBeat.server.DiscardServer;

/**
 * @Author: Jokeer
 * @Description: TODO
 * @Date: 2024/5/17 22:14
 * @Version: 1.0
 */

public class Starter {

    public static void main(String[] args) throws Exception {
        DiscardServer discardServer = new DiscardServer(9000);
        discardServer.run();



    }
}
