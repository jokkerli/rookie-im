package com.rookie.im.user.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rookie.im.user.domain.entity.User;
import com.rookie.im.user.mapper.UserMapper;
import com.rookie.im.user.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 菜鸟 IM 用户表 服务实现类
 * </p>
 *
 * @author jokeer
 * @since 2024-04-22
 */
@Service
public class UserDao extends ServiceImpl<UserMapper, User>{

    @Autowired
    private UserMapper userMapper;

    public User getSingleUserInfo(String userId, Long appId){
        return lambdaQuery()
                .eq(User::getAppId,appId)
                .eq(User::getUserId,userId)
                .eq(User::getForbiddenFlag,0)
                .one();
    }

    public Page<User> getAllUserInfo(Page page, Long appId) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>().eq("app_id", appId);
        Page<User> users = userMapper.selectPage(page, queryWrapper);
        return users;
    }
}
