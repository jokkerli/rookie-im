package com.rookie.im.user.domain.vo.req;

import com.rookie.im.common.domain.req.BaseRequest;
import com.rookie.im.user.domain.dto.ImportUserEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;

import javax.validation.Valid;
import java.util.List;

/**
 * @Author: Jokeer
 * @Description: TODO
 * @Date: 2024/4/22 21:06
 * @Version: 1.0
 */
@Data
@Tag(name = "批量导入用户参数实体")
public class ImportUserRequest extends BaseRequest {

    @Schema(description = "导入用户资料列表")
    private List<@Valid ImportUserEntity> userList;

}