package com.rookie.im.friendship.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Author: Jokeer
 * @Description: TODO
 * @Date: 2024/4/24 14:12
 * @Version: 1.0
 */

@Data
public class FriendDto {

    @NotBlank
    private String toId;

    private String remark;

    private String addSource;

    private String extra;

    private String addWording;




}