package com.rookie.im.friendship.dao;

import com.rookie.im.friendship.domain.entity.Friendship;
import com.rookie.im.friendship.mapper.FriendshipMapper;
import com.rookie.im.friendship.service.IFriendshipService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jokeer
 * @since 2024-04-24
 */
@Service
public class FriendshipDao extends ServiceImpl<FriendshipMapper, Friendship>{

    public Friendship getFriendShip(String fromId, String toId, Long appId) {

        return lambdaQuery()
                .eq(Friendship::getAppId,appId)
                .eq(Friendship::getFromId,fromId)
                .eq(Friendship::getToId,toId)
                .one();
    }
}
