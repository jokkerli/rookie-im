package com.rookie.im.common.exception;

import lombok.Data;
import lombok.experimental.SuperBuilder;

/**
 * @Author: Jokeer
 * @Description: 自定义异常（业务异常）
 * @Date: 2024/4/23 11:12
 * @Version: 1.0
 */
@Data
public class BusinessException extends RuntimeException{

    private Integer code;

    private String msg;

    public BusinessException(){
        super();
    }

    public BusinessException(String msg){
        super(msg);
        this.msg = msg;
    }
    public BusinessException(ErrorEnum error){
        super(error.getErrorMsg());
        this.code = error.getErrorCode();
        this.msg = error.getErrorMsg();
    }


    public BusinessException(Integer e, String msg) {
        super(msg);
        this.code = e;
        this.msg =msg;
    }
}
