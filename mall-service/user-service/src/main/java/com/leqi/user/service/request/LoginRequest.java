package com.leqi.user.service.request;

import lombok.Data;

/**
 * @author lwep
 * @dareTime 2019/9/4 17:03
 */
@Data
public class LoginRequest {
    private String username;
    private String password;
}
