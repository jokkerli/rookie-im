package com.rookie.im.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: Jokeer
 * @Description: TODO
 * @Date: 2024/4/24 13:57
 * @Version: 1.0
 */
@AllArgsConstructor
@Getter
public enum  FriendShipErrorEnum implements ErrorEnum{

    OUTBOUND_IMPORT_FRIEND_LIMIT(-4,"超出导入好友的最大限制"),
    TO_IS_YOUR_FRIEND(-5,"TO好友已是你的好友")
    ;

    private Integer code;

    private String msg;


    @Override
    public Integer getErrorCode() {
        return null;
    }

    @Override
    public String getErrorMsg() {
        return null;
    }
}
