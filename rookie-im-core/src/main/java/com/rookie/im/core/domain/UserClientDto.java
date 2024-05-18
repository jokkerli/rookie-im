package com.rookie.im.core.domain;

import lombok.Data;

/**
 * @Author: Jokeer
 * @Description: TODO
 * @Date: 2024/5/18 15:56
 * @Version: 1.0
 */

@Data
public class UserClientDto {

    private Integer appId;

    private Integer clientType;

    private String userId;

    private String imei;

}