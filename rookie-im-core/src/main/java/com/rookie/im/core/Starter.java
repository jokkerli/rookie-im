package com.rookie.im.core;

import com.rookie.im.core.config.AppConfig;
import com.rookie.im.core.server.ImServer;
import com.rookie.im.core.utils.redis.RedisManager;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @Author: Jokeer
 * @Description: TODO
 * @Date: 2024/5/18 12:57
 * @Version: 1.0
 */

public class Starter {

    public static void main(String[] args) {
        if (args.length > 0) {
            start(args[0]);
        }
    }

    public static void start(String path){
        Yaml yaml = new Yaml();
        InputStream inputStream = null;
        try {
            // 读取配置文件
            inputStream = new FileInputStream(path);
            AppConfig appConfig = yaml.loadAs(inputStream, AppConfig.class);
            // 启动 websocket 服务
            // 启动 IM server 在单独的线程中
            new Thread(() -> {
                new ImServer(appConfig.getRookie());
            }).start();

            // 启动 redis
            RedisManager.init(appConfig);
//
//            MqFactory.init(appConfig.getRookie().getRabbitmq());
//
//            MessageReciver.init();

        }catch (Exception e){
            e.printStackTrace();
            System.exit(500);
        }
    }
}
