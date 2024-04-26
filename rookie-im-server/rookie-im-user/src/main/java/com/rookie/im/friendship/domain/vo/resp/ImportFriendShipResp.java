package com.rookie.im.friendship.domain.vo.resp;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;

import java.util.List;

/**
 * @Author: Jokeer
 * @Description: TODO
 * @Date: 2024/4/24 13:30
 * @Version: 1.0
 */

@Data
@Tag(name = "导入好友关系响应实体")
public class ImportFriendShipResp {

    @Schema(name = "导入失败的id列表")
    private List<String> errorId;
}