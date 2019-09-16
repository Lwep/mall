package com.leqi.user.service.service.impl;

import com.leqi.user.service.entity.User;
import com.leqi.user.service.mapper.UserMapper;
import com.leqi.user.service.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
