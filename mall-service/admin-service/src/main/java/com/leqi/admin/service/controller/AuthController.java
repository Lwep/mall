package com.leqi.admin.service.controller;

import com.leqi.admin.service.request.LoginRequest;
import com.leqi.common.core.Result;
import org.springframework.web.bind.annotation.*;

/**
 * @author lwep
 * @dareTime 2019/9/4 16:58
 */
@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {
    @PostMapping("login")
    public Result login(@RequestBody LoginRequest loginRequest){
   
    }
}
