package com.leqi.user.service.service;

import com.leqi.user.service.UserServiceApplicationTests;
import com.leqi.user.service.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author lwep
 * @dareTime 2019/9/16 14:23
 */
@Slf4j
public class UserServiceTest extends UserServiceApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void save(){
        List<User> list = new ArrayList<>();
        for(int i = 0;i<20;i++){
            User user = new User();
            user.setUsername("用户"+i);
            user.setPhone("123");
            user.setImg("asdasda");
            list.add(user);
        }
    userService.saveBatch(list);

    }

}