package com.leqi.admin.service.controller;

import com.leqi.admin.service.entity.Admin;
import com.leqi.admin.service.request.LoginRequest;
import com.leqi.admin.service.service.AdminService;
import com.leqi.common.constrant.GlobalConstrant;
import com.leqi.common.core.Result;
import com.leqi.common.utils.JwtUtils;
import com.leqi.common.utils.Md5Utils;
import com.leqi.common.utils.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.Serializable;

/**
 * @author lwep
 * @dareTime 2019/9/4 16:58
 */
@RestController
@RequestMapping("/auth")
@Slf4j
public class AuthController {
    @Autowired
    private RedisTemplate<String, Serializable> redisTemplate;
    @Autowired
    private AdminService adminService;

    @PostMapping("login")
    public Result login(@RequestBody LoginRequest loginRequest) {
        Admin admin = adminService.login(loginRequest);
        if (null != admin) {
            //TODO 生成令牌
            String token = JwtUtils.sign(loginRequest.getUsername(), Md5Utils.getMD5String(GlobalConstrant.JWT_SECRET));
            RedisUtils redisUtils = new RedisUtils();
            redisUtils.setRedisTemplate(redisTemplate);
            //TODO 添加有效期  放入redis
            redisUtils.set(admin.getUsername(), admin, GlobalConstrant.EXPIRE_TIME);
            return Result.ok("登录成功", token);
        }
        return Result.fail("登录失败");
    }
}
