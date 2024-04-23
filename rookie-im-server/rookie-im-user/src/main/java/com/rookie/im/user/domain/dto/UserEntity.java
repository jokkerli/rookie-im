package com.rookie.im.user.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author eumenides
 * @description
 * @date 2024/3/27
 */
@Data
@Tag(name = "用户资料实体")
public class UserEntity {

    @Schema(description = "用户ID")
    private String userId;


    @Schema(description = "用户名")
    private String userName;
    /**
     * 用户手机号
     */
    @Schema(description = "用户手机号")
    private String mobile;

    /**
     * 用户邮箱
     */
    @Schema(description = "用户邮箱")
    private String email;

    /**
     * 用户头像
     */
    @Schema(description = "用户头像")
    private String avatar;

    /**
     * 用户性别（0：未知，1：男，2：女））
     */
    @Schema(description = "用户性别")
    private Integer sex;

    /**
     * 个性签名
     */
    @Schema(description = "用户个性签名")
    private String selfSignature;

    @Schema(description = "管理员禁止用户添加加好友：0 未禁用 1 已禁用")
    private Integer disableAddFriend;


    @Schema(description = "加好友验证类型（Friend_AllowType） 1无需验证 2需要验证")
    private Integer friendAllowType;
}
