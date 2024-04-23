package com.rookie.im.user.domain.dto;

import com.rookie.im.common.annotations.IsMobile;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

/**
 * @Author: Jokeer
 * @Description: TODO
 * @Date: 2024/4/22 21:10
 * @Version: 1.0
 */
@Data
@Tag(name = "导入用户资料实体")
public class ImportUserEntity {

    @NotNull(message = "用户名不能为空")
    @Schema(description = "用户名")
    private String userName;
    /**
     * 用户手机号
     */
    //TODO 自定义注解 （判断是否符合手机号格式）
    @IsMobile
    @NotNull(message = "手机号不能为空")
    @Schema(description = "用户手机号")
    private String mobile;

    /**
     * 用户邮箱
     */
    @Email
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
}