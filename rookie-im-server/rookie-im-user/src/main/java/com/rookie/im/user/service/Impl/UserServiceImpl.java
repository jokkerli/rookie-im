package com.rookie.im.user.service.Impl;

import com.rookie.im.common.exception.BusinessException;
import com.rookie.im.common.exception.UserErrorEnum;
import com.rookie.im.common.exception.UserException;
import com.rookie.im.user.dao.UserDao;
import com.rookie.im.user.domain.dto.ImportUserEntity;
import com.rookie.im.user.domain.entity.User;
import com.rookie.im.user.domain.vo.req.ImportUserRequest;
import com.rookie.im.user.domain.vo.resp.ImportUserResp;
import com.rookie.im.user.service.IUserService;
import com.rookie.im.user.service.adapter.ImportUserAdapter;
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
}
