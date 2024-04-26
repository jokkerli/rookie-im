package com.rookie.im.friendship.service;

import com.rookie.im.friendship.domain.dto.FriendDto;
import com.rookie.im.friendship.domain.entity.FriendshipRequest;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 加好友申请表 服务类
 * </p>
 *
 * @author jokeer
 * @since 2024-04-24
 */
public interface IFriendshipRequestService{

    Boolean addFriendshipRequest(String userId, FriendDto toItem, Long appId);

    public void approveFriendRequest();
}
