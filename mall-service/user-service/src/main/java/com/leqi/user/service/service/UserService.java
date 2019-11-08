package com.leqi.user.service.service;

import com.leqi.user.service.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.leqi.user.service.request.LoginRequest;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Lwep
 * @since 2019-09-16
 */
public interface UserService extends IService<User> {

    User userLogin(LoginRequest loginRequest);

    boolean userRegister(User user);

}
