package com.rookie.im.common.result;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;

/**
 * @Author: Jokeer
 * @Description: 统一返回结果
 * @Date: 2024/4/22 14:48
 * @Version: 1.0
 */

@Data
@Tag(name ="基础返回体")
public class ApiResult<T> {
    @Schema(description = "成功标识true or false")
    private Boolean success;
    @Schema(description = "错误码")
    private Integer errCode;
    @Schema(description = "错误消息")
    private String errMsg;
    @Schema(description = "返回对象")
    private T data;

    public static <T> ApiResult<T> success() {
        ApiResult<T> result = new ApiResult<>();
        result.setData(null);
        result.setSuccess(Boolean.TRUE);
        return result;
    }

    public static <T> ApiResult<T> fail(Integer code, String msg) {
        ApiResult<T> result = new ApiResult<T>();
        result.setSuccess(Boolean.FALSE);
        result.setErrCode(code);
        result.setErrMsg(msg);
        return result;
    }

    public static <T> ApiResult<T> success(T data) {
        ApiResult<T> result = new ApiResult<T>();
        result.setData(data);
        result.setSuccess(Boolean.TRUE);
        return result;
    }

//    public static <T> ApiResult<T> fail(ErrorEnum errorEnum) {
//        ApiResult<T> result = new ApiResult<T>();
//        result.setSuccess(Boolean.FALSE);
//        result.setErrCode(errorEnum.getErrorCode());
//        result.setErrMsg(errorEnum.getErrorMsg());
//        return result;
//    }

}