package com.leqi.admin.service.entity;

import lombok.Data;

import java.time.LocalDate;

/**
 * @author lwep
 * @dareTime 2019/9/3 16:33
 */
@Data
public class Admin {
    private Long admin_id;
    private String admin_username;
    private String admin_password;
    private String admin_realname;
    private String admin_phone;
    private int admin_status;
    private LocalDate admin_create_time;
    private LocalDate admin_login_time;

}
