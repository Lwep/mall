package com.leqi.admin.service.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDate;

/**
 * @author lwep
 * @dareTime 2019/9/3 16:33
 */
@Data
@TableName("mall_admin")
public class Admin {
    @TableId(value = "id",type = IdType.ID_WORKER)
    private Long id;
    private String username;
    private String password;
    private String realname;
    private String phone;
    private int status;
    @TableField (value = "login_time")
    private LocalDate create_time;
    @TableField (value = "login_time")
    private LocalDate login_time;

}
