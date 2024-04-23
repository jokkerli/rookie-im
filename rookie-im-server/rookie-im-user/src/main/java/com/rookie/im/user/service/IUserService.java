package com.rookie.im.user.service;

import com.rookie.im.user.domain.dto.ImportUserEntity;
import com.rookie.im.user.domain.vo.req.ImportUserRequest;
import com.rookie.im.user.domain.vo.resp.ImportUserResp;

import java.util.List;

/**
 * <p>
 * 菜鸟 IM 用户表 服务类
 * </p>
 *
 * @author jokeer
 * @since 2024-04-22
 */
public interface IUserService{




    public ImportUserResp importUser(ImportUserRequest importUserReq);

}
