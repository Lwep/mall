package com.leqi.user.service.controller;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author lwep
 * @dareTime 2019/8/31 9:51
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Value("${user.test}")
    private String test;

    @GetMapping
    public String getUser() {
        return test;
    }
}
