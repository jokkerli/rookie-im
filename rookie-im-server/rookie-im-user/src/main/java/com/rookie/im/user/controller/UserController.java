package com.rookie.im.user.controller;


import com.rookie.im.common.result.ApiResult;
import com.rookie.im.common.result.PagedResponse;
import com.rookie.im.user.domain.dto.UserEntity;
import com.rookie.im.user.domain.vo.req.ImportUserRequest;
import com.rookie.im.user.domain.vo.resp.ImportUserResp;
import com.rookie.im.user.service.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;

/**
 * <p>
 * 菜鸟 IM 用户表 前端控制器
 * </p>
 *
 * @author jokeer
 * @since 2024-04-22
 */
@Tag(name = "用户控制层")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @PutMapping("/import")
    @Operation(description = "批量导入用户")
    public ApiResult<ImportUserResp> importUser(@RequestBody @Valid ImportUserRequest importUserRequest){
        ImportUserResp importUserResp = userService.importUser(importUserRequest);
        return ApiResult.success(importUserResp);
    }


    @GetMapping("/getSingleUserInfo")
    @Operation(description = "获取单个用户信息")
    public ApiResult<UserEntity> getSingleUserInfo(String userId, Long appId){
        UserEntity singleUserInfo = userService.getSingleUserInfo(userId, appId);
        return ApiResult.success(singleUserInfo);
    }

    @GetMapping("/getAllUserInfo")
    @Operation(description = "获取所有用户信息列表")
    public ApiResult<PagedResponse<UserEntity>> getAllUserInfo(@RequestParam(required = false, defaultValue = "1") Integer page,
                                                               @RequestParam(required = false, defaultValue = "10") Integer pageSize,
                                                               Long appId) {
        PagedResponse<UserEntity> userEntityList = userService.getAllUserInfo(appId, page, pageSize);
        return ApiResult.success(userEntityList);
    }


//    @PostMapping("/modify")
//    @ApiOperation(value = "修改用户资料")
//    public ApiResult<Void> modifyUserInfo(@RequestBody @Valid ModifyUserRequest request){
//        userService.modifyUserInfo(request);
//        return ApiResult.success();
//    }
//
//    @GetMapping("/getUserInfo")
//    @ApiOperation(value = "批量获取用户信息")
//    public ApiResult<GetUserInfoResp> getUserInfo(GetUserInfoReq request){
//        GetUserInfoResp userInfo = userService.getUserInfo(request);
//        return ApiResult.success(userInfo);
//    }
//
//    @GetMapping("/getSingleUserInfo")
//    @ApiOperation(value = "获取单个用户信息")
//    public ApiResult<UserEntity> getSingleUserInfo(String userId, Long appId){
//        UserEntity singleUserInfo = userService.getSingleUserInfo(userId, appId);
//        return ApiResult.success(singleUserInfo);
//    }
//
//    @GetMapping("/getAllUserInfo")
//    @ApiOperation(value = "获取所有用户信息列表")
//    public ApiResult<PagedResponse<UserEntity>> getAllUserInfo(@RequestParam(required = false, defaultValue = "1") Integer page,
//                                                               @RequestParam(required = false, defaultValue = "10") Integer pageSize,
//                                                               Long appId) {
//        PagedResponse<UserEntity> userEntityList = userService.getAllUserInfo(appId, page, pageSize);
//        return ApiResult.success(userEntityList);
//    }

}

