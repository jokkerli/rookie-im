package com.rookie.im.user.controller;


import com.rookie.im.common.result.ApiResult;
import com.rookie.im.user.domain.vo.req.ImportUserRequest;
import com.rookie.im.user.domain.vo.resp.ImportUserResp;
import com.rookie.im.user.service.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

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
    public ApiResult<ImportUserResp> importUser(@RequestBody ImportUserRequest importUserRequest){
        ImportUserResp importUserResp = userService.importUser(importUserRequest);
        return ApiResult.success(importUserResp);
    }


//    RuntimeException

}

