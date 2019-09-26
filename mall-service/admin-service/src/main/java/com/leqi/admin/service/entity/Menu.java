package com.leqi.admin.service.entity;

import com.leqi.common.core.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Lwep
 * @since 2019-09-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Menu extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 路由名
     */
    private String name;

    /**
     * 路径

     */
    private String path;

    /**
     * 显示名称
     */
    private String menuName;

    /**
     * 父级id
     */
    private Long parentId;

    /**
     * 组件
     */
    private String component;




}
