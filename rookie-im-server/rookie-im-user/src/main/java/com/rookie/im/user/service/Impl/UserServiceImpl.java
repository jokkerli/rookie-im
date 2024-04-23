package com.rookie.im.user.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rookie.im.common.exception.BusinessException;
import com.rookie.im.common.exception.UserErrorEnum;
import com.rookie.im.common.exception.UserException;
import com.rookie.im.common.result.PagedResponse;
import com.rookie.im.user.dao.UserDao;
import com.rookie.im.user.domain.dto.ImportUserEntity;
import com.rookie.im.user.domain.dto.UserEntity;
import com.rookie.im.user.domain.entity.User;
import com.rookie.im.user.domain.vo.req.ImportUserRequest;
import com.rookie.im.user.domain.vo.resp.ImportUserResp;
import com.rookie.im.user.mapper.UserMapper;
import com.rookie.im.user.service.IUserService;
import com.rookie.im.user.service.adapter.ImportUserAdapter;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    @Autowired
    private UserMapper userMapper;

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

        //TODO 创建AssertUtil进行断言判断
//        AssertUtil.isEmpty(user, UserErrorEnum.USER_IS_NOT_EXIST,"");
        if(user == null){
            return null;
        }

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
}
