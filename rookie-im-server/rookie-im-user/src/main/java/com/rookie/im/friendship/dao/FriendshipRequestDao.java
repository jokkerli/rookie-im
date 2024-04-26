package com.rookie.im.friendship.dao;

import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.rookie.im.friendship.domain.entity.FriendshipRequest;
import com.rookie.im.friendship.mapper.FriendshipRequestMapper;
import com.rookie.im.friendship.service.IFriendshipRequestService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 加好友申请表 服务实现类
 * </p>
 *
 * @author jokeer
 * @since 2024-04-24
 */
@Service
public class FriendshipRequestDao extends ServiceImpl<FriendshipRequestMapper, FriendshipRequest>{
    public FriendshipRequest getFriendshipRequest(String fromId, String toId, Long appId) {

        return lambdaQuery()
                .eq(FriendshipRequest::getAppId,appId)
                .eq(FriendshipRequest::getFromId,fromId)
                .eq(FriendshipRequest::getToId,toId)
                .one();

    }

}
