package com.leqi.admin.service.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.leqi.common.core.BaseEntity;
import lombok.Data;

import java.time.LocalDate;

/**
 * @author lwep
 * @dareTime 2019/8/31 9:29
 */
@Data
@TableName("mall_admin")
public class Admin extends BaseEntity {
    private Long id;
    private String username;
    private String password;
    private String realname;
    private String phone;
}
