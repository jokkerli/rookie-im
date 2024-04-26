package com.rookie.im.friendship.service.adapter;

import cn.hutool.core.bean.BeanUtil;
import com.fasterxml.jackson.datatype.jsr310.deser.InstantDeserializer;
import com.rookie.im.friendship.domain.entity.Friendship;
import com.rookie.im.friendship.domain.vo.req.ImportFriendShipReq;

/**
 * @Author: Jokeer
 * @Description: TODO
 * @Date: 2024/4/24 13:46
 * @Version: 1.0
 */

public class FriendShipAdapter {


    public static Friendship importFriendShipSave(Long appId, String fromId,
                                                  ImportFriendShipReq.ImportFriendDto dto){
        Friendship friendship = new Friendship();

        BeanUtil.copyProperties(dto,friendship);

        friendship.setAppId(appId);

        friendship.setFromId(fromId);


        return friendship;
    }

}
