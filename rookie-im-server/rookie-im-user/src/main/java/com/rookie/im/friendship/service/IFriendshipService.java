package com.rookie.im.friendship.service;

import com.rookie.im.friendship.domain.dto.FriendDto;
import com.rookie.im.friendship.domain.entity.Friendship;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rookie.im.friendship.domain.vo.req.AddFriendReq;
import com.rookie.im.friendship.domain.vo.req.ImportFriendShipReq;
import com.rookie.im.friendship.domain.vo.resp.ImportFriendShipResp;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jokeer
 * @since 2024-04-24
 */
public interface IFriendshipService{

    ImportFriendShipResp importFriendShip(ImportFriendShipReq req);

    void addFriend(AddFriendReq req);

    public void doAddFriend(String fromId, FriendDto dto, Long appId);
}
