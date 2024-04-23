package com.rookie.im.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum BusinessErrorEnum implements ErrorEnum{

    BUSINESS_ERROR(1001,"{0}"),

    SYSTEM_ERROR(1002,"系统开小差了，请稍后再试！")

    ;
    private Integer code;

    private String msg;

    @Override
    public Integer getErrorCode() {
        return this.code;
    }

    @Override
    public String getErrorMsg() {
        return this.msg;
    }
}
