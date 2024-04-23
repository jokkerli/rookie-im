package com.rookie.im.common.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

/**
 * @Author: Jokeer
 * @Description: TODO
 * @Date: 2024/4/23 13:56
 * @Version: 1.0
 */
@AllArgsConstructor
@Getter
public enum  UserErrorEnum implements ErrorEnum{

    IMPORT_USER_OUT_OF_LIMIT(-1,"导入用户记录总数超出最大限制"),
    MODIFY_USER_INFO_ERROR(-3,"修改用户信息错误")
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
