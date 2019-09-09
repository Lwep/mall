package com.leqi.admin.service.controller;

import com.leqi.admin.service.request.LoginRequest;
import com.leqi.common.core.Result;
import com.leqi.common.utils.Md5Utils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author lwep
 * @dareTime 2019/9/4 16:58
 */
@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @PostMapping("login")
    public Result login(@RequestBody LoginRequest loginRequest, HttpSession httpSession){
        if(loginRequest.getUsername().equals("admin")
                &&loginRequest.getPassword().equals("23")){
            String token = Md5Utils.getMD5String(loginRequest.getUsername()+"ad");
            httpSession.setAttribute("token",token);
            return Result.ok("登录成功",token);
        }
        return Result.fail("登录失败");
    }
}
