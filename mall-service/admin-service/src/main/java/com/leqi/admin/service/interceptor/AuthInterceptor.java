package com.leqi.admin.service.interceptor;


import com.alibaba.fastjson.JSON;
import com.leqi.admin.service.entity.Admin;
import com.leqi.common.constrant.GlobalConstrant;
import com.leqi.common.core.Result;
import com.leqi.common.utils.JwtUtils;
import com.leqi.common.utils.Md5Utils;
import com.leqi.common.utils.RedisUtils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

/**
 * @author lwep
 * @dareTime 2019/9/9 15:46
 */
@Slf4j
//@Configuration
public class AuthInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisTemplate<String, Serializable> redisTemplate;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //log.info("url+++"+request.getRequestURI());
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("utf8");
        // 使用Redis获取Token
        RedisUtils redisUtils = new RedisUtils();
        redisUtils.setRedisTemplate(redisTemplate);


        if (request.getRequestURI().contains("login")) {
            return true;
        }
        // 获取令牌
        String token = request.getHeader("admin_token");

        //TODO 有令牌
        if (StringUtils.isNotEmpty(token)) {
            String username = JwtUtils.getUsername(token);
            String password = Md5Utils.getMD5String(GlobalConstrant.JWT_SECRET);
            //防篡改
            if (JwtUtils.verify(token, username, password)) {
                //获取用户信息
                Admin admin = (Admin) redisUtils.get(username);
                //TODO 保存当前用户
                redisUtils.set("current_user", admin.getUsername());
                return true;
            } else {
                Result result = Result.fail("令牌不正确");
                PrintWriter printWriter = response.getWriter();
                printWriter.write(JSON.toJSONString(result));
                return false;
            }
        }
        Result result = Result.fail("没有认证");
        PrintWriter printWriter = response.getWriter();
        printWriter.write(JSON.toJSONString(result));
        return false;
    }
}

