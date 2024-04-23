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
        // TODO 在这里设置默认属性
        user.setAppId(appId);
        // TODO 这里可以使用雪花算法
        user.setUserId(UUID.randomUUID().toString());
        //TODO 修改出枚举  YESORNO
        user.setForbiddenFlag(0);
        return user;
    }

    public static UserEntity buildUserInfo(User user) {
        UserEntity entity = new UserEntity();
        BeanUtil.copyProperties(user, entity);
        return entity;
    }
}
