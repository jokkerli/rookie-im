package com.rookie.im.user.domain.vo.resp;

import com.rookie.im.user.domain.dto.UserEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;

import java.util.List;

/**
 * @Author: Jokeer
 * @Description: TODO
 * @Date: 2024/4/23 16:56
 * @Version: 1.0
 */
@Data
@Tag(name = "批量查询用户返回实体")
public class GetUserInfoResp {

    @Schema(description = "用户实体链表")
    List<UserEntity> userEntityList;

    @Schema(description = "查询错误的用户id列表")
    List<String> errorIds;
}
