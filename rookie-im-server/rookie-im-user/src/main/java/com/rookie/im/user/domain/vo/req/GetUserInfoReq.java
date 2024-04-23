package com.rookie.im.user.domain.vo.req;

import com.rookie.im.common.domain.req.BaseRequest;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;

import java.util.List;

/**
 * @Author: Jokeer
 * @Description: 批量获取用户请求参数
 * @Date: 2024/4/23 16:55
 * @Version: 1.0
 */

@Data
@Tag(name = "批量查询用户请求参数实体")
public class GetUserInfoReq extends BaseRequest {
    @Schema(description = "待查询用户id列表")
    private List<String> userIds;
}