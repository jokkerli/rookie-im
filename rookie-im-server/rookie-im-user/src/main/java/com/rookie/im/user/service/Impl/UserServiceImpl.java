package com.rookie.im.user.service.Impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rookie.im.common.exception.BusinessException;
import com.rookie.im.common.exception.UserErrorEnum;
import com.rookie.im.common.exception.UserException;
import com.rookie.im.common.result.PagedResponse;
import com.rookie.im.common.util.AssertUtil;
import com.rookie.im.user.dao.UserDao;
import com.rookie.im.user.domain.dto.ImportUserEntity;
import com.rookie.im.user.domain.dto.UserEntity;
import com.rookie.im.user.domain.entity.User;
import com.rookie.im.user.domain.vo.req.GetUserInfoReq;
import com.rookie.im.user.domain.vo.req.ImportUserRequest;
import com.rookie.im.user.domain.vo.req.ModifyUserRequest;
import com.rookie.im.user.domain.vo.resp.GetUserInfoResp;
import com.rookie.im.user.domain.vo.resp.ImportUserResp;
import com.rookie.im.user.mapper.UserMapper;
import com.rookie.im.user.service.IUserService;
import com.rookie.im.user.service.adapter.ImportUserAdapter;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Jokeer
 * @Description: TODO
 * @Date: 2024/4/22 14:48
 * @Version: 1.0
 */

@Service
public class UserServiceImpl implements IUserService {

    public static final int IMPORT_USE_MAX_LIMIT = 1;
    @Autowired
    private UserDao userDao;

    @Override
    public ImportUserResp importUser(ImportUserRequest importUserReq) {

        if(importUserReq.getUserList().size() > IMPORT_USE_MAX_LIMIT){
            throw  new UserException(UserErrorEnum.IMPORT_USER_OUT_OF_LIMIT);
        }

        ImportUserResp importUserResp = new ImportUserResp();

        ArrayList<String> userList = new ArrayList<>();

        if(importUserReq.getUserList().size() > IMPORT_USE_MAX_LIMIT){
            return new ImportUserResp();
        }

        importUserReq.getUserList().forEach(e ->{
            User user = ImportUserAdapter.importUserSave(importUserReq.getAppId(), e);
            boolean flag = userDao.save(user);
            if(!flag){
                userList.add(user.getId().toString());
            }
        });

        importUserResp.setErrorImportUserName(userList);

        return importUserResp;
    }

    @Override
    public UserEntity getSingleUserInfo(String userId, Long appId) {

        User user = userDao.getSingleUserInfo(userId, appId);
        AssertUtil.isEmpty(user, UserErrorEnum.USER_IS_NOT_EXIST,"");
        return ImportUserAdapter.buildUserInfo(user);
    }

    @Override
    public PagedResponse<UserEntity> getAllUserInfo(Long appId, Integer page, Integer pageSize) {
        Page<User> userPage = new Page<>(page, pageSize);

        Page<User> users = userDao.getAllUserInfo(userPage,appId);

        PagedResponse<UserEntity> response = new PagedResponse<>();

        ArrayList<UserEntity> list = new ArrayList<>();

        users.getRecords().forEach(
                e -> {
                    UserEntity userEntity = ImportUserAdapter.buildUserInfo(e);
                    list.add(userEntity);
                });
        response.setPage(page);
        response.setPageSize(pageSize);
        response.setData(list);
        response.setTotal(users.getTotal());
        return response;


    }

    @Override
    public GetUserInfoResp getUserInfo(GetUserInfoReq req) {
        GetUserInfoResp resp = new GetUserInfoResp();
        List<UserEntity> userEntities = new ArrayList<>();
        List<String> errorIds = new ArrayList<>();
        for (String userId : req.getUserIds()) {
            User user = userDao.getUserInfoByUserId(userId, req.getAppId());
            if (user != null) {
                UserEntity entity = ImportUserAdapter.buildUserInfo(user);
                userEntities.add(entity);
            } else {
                errorIds.add(userId);
            }
        }
        resp.setUserEntityList(userEntities);
        resp.setErrorIds(errorIds);
        return resp;
    }

    @Override
    public void modifyUserInfo(ModifyUserRequest request) {

        if(userDao.getUserInfoByUserId(request.getUserId(),request.getAppId()) == null){
            //抛出异常，用户没找到
            throw new UserException();
        }

        User update = new User();
        BeanUtil.copyProperties(request, update);
        boolean updated = userDao.updateUserInfo(update);
        if (!updated) {
            throw new BusinessException(UserErrorEnum.MODIFY_USER_INFO_ERROR);
        }



    }
}
