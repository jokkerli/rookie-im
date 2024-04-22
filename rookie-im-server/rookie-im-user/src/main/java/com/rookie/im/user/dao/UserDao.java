package com.rookie.im.user.dao;

import com.rookie.im.user.domain.entity.User;
import com.rookie.im.user.mapper.UserMapper;
import com.rookie.im.user.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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

}
