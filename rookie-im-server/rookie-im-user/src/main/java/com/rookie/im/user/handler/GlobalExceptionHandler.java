package com.rookie.im.user.handler;

import com.google.protobuf.Api;
import com.rookie.im.common.exception.BusinessErrorEnum;
import com.rookie.im.common.exception.BusinessException;
import com.rookie.im.common.exception.CommonErrorEnum;
import com.rookie.im.common.exception.UserException;
import com.rookie.im.common.result.ApiResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author: Jokeer
 * @Description: 统一异常处理类
 * @Date: 2024/4/23 14:01
 * @Version: 1.0
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserException.class)
    public ApiResult handlerUserException(UserException e){
        log.info("接收到了异常{}",e.getMsg(),e);
        return ApiResult.fail(e.getCode(),e.getMsg());
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiResult handlerMethodArgumentNotValidException(MethodArgumentNotValidException e){
        log.info("接收到了异常{}",e.getMessage(),e);
        return ApiResult.fail(CommonErrorEnum.PARAM_INVALID.getErrorCode(),CommonErrorEnum.PARAM_INVALID.getErrorMsg());
    }

    @ExceptionHandler(BusinessException.class)
    public ApiResult handlerBusinessException(BusinessException e){
        log.info("接收到了异常{}",e.getMessage(),e);
        return ApiResult.fail(BusinessErrorEnum.BUSINESS_ERROR.getCode(),BusinessErrorEnum.BUSINESS_ERROR.getMsg());
    }

}
