package com.rookie.im.friendship.domain.vo.req;

import com.rookie.im.common.domain.req.BaseRequest;
import com.rookie.im.friendship.domain.dto.FriendDto;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Author: Jokeer
 * @Description: TODO
 * @Date: 2024/4/24 14:08
 * @Version: 1.0
 */
@Data
@Tag(name = "添加好友请求参数实体")
public class AddFriendReq extends BaseRequest {

    @Schema(description = "从 ID")
    @NotBlank( message = "fromId不能为空")
    private String fromId;

    @Schema(description = "添加的对象")
    private FriendDto toItem;


}
