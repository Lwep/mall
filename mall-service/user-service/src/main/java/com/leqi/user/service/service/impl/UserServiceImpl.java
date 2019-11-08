package com.leqi.user.service.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.leqi.user.service.entity.User;
import com.leqi.user.service.mapper.UserMapper;
import com.leqi.user.service.request.LoginRequest;
import com.leqi.user.service.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Lwep
 * @since 2019-09-16
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User userLogin(LoginRequest loginRequest) {
        QueryWrapper<User> queryWrapper = new QueryWrapper();
        queryWrapper.eq("username",loginRequest.getUsername());
        queryWrapper.eq("password",loginRequest.getPassword());
        User user = userMapper.selectOne(queryWrapper);
        if(null!=user){
            return user;
        }
        return null;
    }

    @Override
    public boolean userRegister(User user) {
        if(userMapper.insert(user)>0){
            return true;
        }
        return false;
    }
}
