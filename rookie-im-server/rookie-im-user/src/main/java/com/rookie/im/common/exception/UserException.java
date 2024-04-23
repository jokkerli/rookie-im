package com.rookie.im.common.exception;

import lombok.Data;

/**
 * @Author: Jokeer
 * @Description: TODO
 * @Date: 2024/4/23 13:58
 * @Version: 1.0
 */
@Data
public class UserException extends RuntimeException{

    private Integer code;

    private String msg;

    public UserException(){
        super();
    }

    public UserException(ErrorEnum error){
        super(error.getErrorMsg());
        this.code = error.getErrorCode();
        this.msg = error.getErrorMsg();
    }
}
