package com.rookie.im.friendship.domain.vo.req;

import com.rookie.im.common.domain.req.BaseRequest;
import com.rookie.im.common.enums.FriendShipStatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;
import sun.plugin.dom.exception.NoModificationAllowedException;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @Author: Jokeer
 * @Description: TODO
 * @Date: 2024/4/24 13:30
 * @Version: 1.0
 */

@Data
@Tag(name = "导入好友关系请求参数实体")
public class ImportFriendShipReq extends BaseRequest {

    @Schema(description = "从 ID")
    @NotBlank(message = "fromId不能为空")
    private String fromId;

    @Schema(description = "添加的对象列表")
    private List<ImportFriendDto> friendItem;

    @Data
    @Tag(name = "导入好友对象数据转换实体")
    public static class ImportFriendDto{
        @Schema(description = "to ID")
        private String toId;

        @Schema(description = "标记")
        private String remark;
        @Schema(description = "添加的途径")
        private String addSource;
        @Schema(description = "好友关系状态")
        private Integer status = FriendShipStatusEnum.FRIEND_STATUS_NO_FRIEND.getCode();
        @Schema(description = "是否为黑名单")
        private Integer black = FriendShipStatusEnum.BLACK_STATUS_NORMAL.getCode();
    }



}