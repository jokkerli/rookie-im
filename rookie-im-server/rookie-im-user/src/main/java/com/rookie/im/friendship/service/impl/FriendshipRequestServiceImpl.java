package com.rookie.im.friendship.service.impl;

import com.rookie.im.common.enums.ApproveFriendRequestEnum;
import com.rookie.im.common.enums.FriendShipRequestReadStatusEnum;
import com.rookie.im.common.enums.YesOrNoEnum;
import com.rookie.im.friendship.dao.FriendshipRequestDao;
import com.rookie.im.friendship.domain.dto.FriendDto;
import com.rookie.im.friendship.domain.entity.FriendshipRequest;
import com.rookie.im.friendship.service.IFriendshipRequestService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Jokeer
 * @Description: TODO
 * @Date: 2024/4/24 15:27
 * @Version: 1.0
 */
@Service
public class FriendshipRequestServiceImpl implements IFriendshipRequestService {
    @Autowired
    private FriendshipRequestDao friendshipRequestDao;


    @Override
    public Boolean addFriendshipRequest(String fromId, FriendDto dto, Long appId) {
        Boolean res;

        FriendshipRequest request = friendshipRequestDao.getFriendshipRequest(fromId, dto.getToId(), appId);
        // 这里不适用断言的原因是，判断完成后业务逻辑，并不是报错
        if (request == null) {
            // 不存在加好友申请，那就新建一个
            request = new FriendshipRequest();
            request.setFromId(fromId);
            request.setToId(dto.getToId());
            request.setAppId(appId);
            request.setAddLetter(dto.getAddWording());
            request.setReadStatus(FriendShipRequestReadStatusEnum.UNREAD.getStatus());
            request.setApproveStatus(ApproveFriendRequestEnum.WAIT.getStatus());
            request.setRemark(dto.getRemark());
            request.setAddSource(dto.getAddSource());

            res = friendshipRequestDao.save(request);
        } else {
            // 如果这条记录已经存在了，那就更新一下申请记录，说明是多次发送申请
            // TODO 这里的代码得优化
            if (StringUtils.isNoneBlank(dto.getAddWording())) {
                request.setAddLetter(dto.getAddWording());
            }

            if (StringUtils.isNoneBlank(dto.getRemark())) {
                request.setRemark(dto.getRemark());
            }

            if (StringUtils.isNoneBlank(dto.getAddSource())) {
                request.setAddSource(dto.getAddSource());
            }
            res = friendshipRequestDao.updateById(request);
        }
        return  res;
    }


    @Override
    public void approveFriendRequest() {

    }
}
