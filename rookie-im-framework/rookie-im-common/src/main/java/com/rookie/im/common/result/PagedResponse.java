package com.rookie.im.common.result;

import lombok.Data;

import java.util.List;

/**
 * @Author: Jokeer
 * @Description: TODO
 * @Date: 2024/4/23 16:22
 * @Version: 1.0
 */
@Data
public class PagedResponse<T> {

    private Integer page;

    private Integer pageSize;

    private Long total;

    private List<T> data;



}
