package com.rookie.im.user.service.adapter;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.UUID;

import com.rookie.im.user.domain.dto.ImportUserEntity;
import com.rookie.im.user.domain.dto.UserEntity;
import com.rookie.im.user.domain.entity.User;

/**
 * @Author: Jokeer
 * @Description: TODO
 * @Date: 2024/4/22 21:25
 * @Version: 1.0
 */

public class ImportUserAdapter {

    public static User importUserSave(Long appId, ImportUserEntity entity) {
        User user = new User();
        BeanUtil.copyProperties(entity, user);
        user.setAppId(appId);
        user.setUserId(UUID.randomUUID().toString());
        user.setForbiddenFlag(YesOrNoEnum.NO.getStatus());
        return user;
    }

    public static UserEntity buildUserInfo(User user) {
        UserEntity entity = new UserEntity();
        BeanUtil.copyProperties(user, entity);
        return entity;
    }
}
