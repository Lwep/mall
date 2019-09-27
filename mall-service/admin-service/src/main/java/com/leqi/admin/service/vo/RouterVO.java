package com.leqi.admin.service.vo;

import lombok.Data;

/**
 * @author lwep
 * @dareTime 2019/9/27 15:02
 */
@Data
public class RouterVO {
    /**
     * 名称
     */
    private String name;
    /**
     * 路径
     */
    private String path;
    /**
     * 组件
     */
    private String component;
}
