package com.leqi.user.service.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.leqi.common.core.BaseEntity;
import lombok.Data;


/**
 * <p>
 * 
 * </p>
 *
 * @author Lwep
 * @since 2019-09-16
 */
@Data
@TableName("user_user")
public class User extends BaseEntity {
    private String username;
    private String password;
    private String img;
    private String phone;
}
