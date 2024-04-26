package com.rookie.im.friendship.controller;


import com.rookie.im.common.result.ApiResult;
import com.rookie.im.friendship.domain.vo.req.AddFriendReq;
import com.rookie.im.friendship.domain.vo.req.ImportFriendShipReq;
import com.rookie.im.friendship.domain.vo.resp.ImportFriendShipResp;
import com.rookie.im.friendship.service.IFriendshipService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.validation.Valid;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jokeer
 * @since 2024-04-24
 */
@Tag(name = "好友关系控制层")
@RestController
@RequestMapping("/friendship")
public class FriendshipController {


    @Autowired
    private IFriendshipService friendshipService;

    @Operation(summary = "批量导入好友关系")
    @PutMapping("/importFriendShip")
    public ApiResult<ImportFriendShipResp> importFriendShip(@RequestBody @Valid ImportFriendShipReq req) {
        return ApiResult.success(friendshipService.importFriendShip(req));
    }
//
    @Operation(summary = "添加好友关系")
    @PostMapping("/addFriendShip")
    public ApiResult<Void> addFriend(@RequestBody @Valid AddFriendReq req) {
        friendshipService.addFriend(req);
        return ApiResult.success();
    }

}

