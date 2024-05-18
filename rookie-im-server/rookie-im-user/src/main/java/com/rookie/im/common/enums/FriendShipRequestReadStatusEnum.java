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
 * @Date: 2024/4/26 21:32
 * @Version: 1.0
 */
@AllArgsConstructor
@Getter
public enum  FriendShipRequestReadStatusEnum {

    REATED(1,"已读"),
    UNREAD(0,"未读")
    ;
    /**
     * 状态
     */
    private final int status;

    /**
     * 描述
     */
    private final String desc;

    private static  Map<Integer,FriendShipRequestReadStatusEnum> cache ;

    static {
        cache = Arrays.stream(FriendShipRequestReadStatusEnum.values()).collect(Collectors.toMap(FriendShipRequestReadStatusEnum::getStatus, Function.identity()));
//        cache = Arrays.stream(FriendShipRequestReadStatusEnum.values()).collect()
    }




}
