package com.leqi.admin.service.vo;

import lombok.Data;

import java.util.Set;

/**
 * @author lwep
 * @dareTime 2019/9/26 9:29
 */
@Data
public class MenuVO {
    private Long id;
    private String title;
    private String icon;
    private String key;
    private String path;
    private Set<MenuVO> children;
}
