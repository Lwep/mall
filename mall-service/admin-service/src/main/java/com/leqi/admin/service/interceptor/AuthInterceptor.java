package com.leqi.admin.service.interceptor;

import com.alibaba.fastjson.JSON;
import com.leqi.common.core.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author lwep
 * @dareTime 2019/9/9 15:46
 */
@Slf4j
@Configuration
public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        //log.info("url+++"+request.getRequestURI());
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("utf8");

        if (request.getRequestURI().contains("login")) {
            return true;
        }
        HttpSession httpSession = request.getSession();
        Object token = httpSession.getAttribute("token");

        if (null != token && request.getHeader("admin_token").equals(token.toString())) {
            return true;
        }
        Result result = Result.fail("没有认证");
        PrintWriter printWriter = null;
        try {
            printWriter = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        printWriter.write(JSON.toJSONString(result));
        return false;


    }
}
