package com.rookie.im.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: Jokeer
 * @Description: TODO
 * @Date: 2024/4/23 14:59
 * @Version: 1.0
 */
@AllArgsConstructor
@Getter
public enum  CommonErrorEnum implements ErrorEnum{

    PARAM_INVALID(-2,"参数错误{0}")

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
