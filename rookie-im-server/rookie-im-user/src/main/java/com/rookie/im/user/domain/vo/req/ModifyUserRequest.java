package com.rookie.im.user.domain.vo.req;

import com.rookie.im.common.domain.req.BaseRequest;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @Author: Jokeer
 * @Description: TODO
 * @Date: 2024/4/23 20:47
 * @Version: 1.0
 */
@Data
@Tag(name = "修改用户参数")
public class ModifyUserRequest extends BaseRequest {

    @NotEmpty(message = "用户id不能为空")
    private String userId;

    @Schema(description = "用户名")
    private String userName;

    @Schema(description = "用户头像")
    private String avatar;
    /**
     * 个性签名
     */
    @Schema(description = "用户个性签名")
    private String selfSignature;

    @Schema(description = "加好友验证类型（Friend_AllowType） 1无需验证 2需要验证")
    private Integer friendAllowType;

    @Schema(description = "扩展字段")
    private String extra;



}