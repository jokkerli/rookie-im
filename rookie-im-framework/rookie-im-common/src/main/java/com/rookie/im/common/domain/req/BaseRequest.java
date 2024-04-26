package com.rookie.im.common.domain.req;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;

import javax.validation.Valid;

/**
 * @Author: Jokeer
 * @Description: TODO
 * @Date: 2024/4/22 21:08
 * @Version: 1.0
 */

@Data
@Tag(name = "基础请求参数")
public class BaseRequest {
    @Schema(description = "app ID")
    private Long appId;

}