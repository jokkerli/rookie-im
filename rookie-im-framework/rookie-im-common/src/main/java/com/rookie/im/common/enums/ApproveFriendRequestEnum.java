package com.rookie.im.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
public enum ApproveFriendRequestEnum {
    /**
     * 待审批
     */
    WAIT(0,"待审批"),
    /**
     * 审批通过
     */
    APPROVE(1,"审批通过" ),
    /**
     * 拒绝
     */
    DISAPPROVE(2,"拒绝" ),
    ;

    private final int status;

    private final String desc;

    private static Map<Integer,ApproveFriendRequestEnum> cache;


    static {
        cache = Arrays.stream(ApproveFriendRequestEnum.values())
                .collect(Collectors.toMap(ApproveFriendRequestEnum::getStatus, Function.identity() ,(existing, replacement) -> existing));
    }

    public static ApproveFriendRequestEnum of(Integer status){
        return  cache.get(status);
    }




}
