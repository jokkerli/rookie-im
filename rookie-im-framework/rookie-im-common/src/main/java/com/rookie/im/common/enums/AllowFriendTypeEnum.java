package com.rookie.im.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Author: Jokeer
 * @Description: TODO
 * @Date: 2024/4/24 14:20
 * @Version: 1.0
 */
@AllArgsConstructor
@Getter
public enum  AllowFriendTypeEnum {
    NOT_NEED(1,"无需验证"),
    NEED(2,"需要验证")
    ;
    /**
     * 状态
     */
    private final int status;

    /**
     * 描述
     */
    private final String desc;
    /**
     * 缓冲池
     */
    private static Map<Integer, AllowFriendTypeEnum> cache;

    static {
        cache = Arrays.stream(AllowFriendTypeEnum.values())
                .collect(Collectors.toMap(AllowFriendTypeEnum::getStatus, Function.identity(),(existing, replacement) -> existing));
    }


    public static AllowFriendTypeEnum of(int code) {
        return cache.get(code);
    }
}
