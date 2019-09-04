package com.leqi.admin.service.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.leqi.common.core.BaseEntity;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author lwep
 * @dareTime 2019/9/3 16:33
 */
@Data
@TableName("mall_admin")
public class Admin extends BaseEntity {
    private String username;
    private String password;
    private String realname;
    private String phone;
    private int status;

}
