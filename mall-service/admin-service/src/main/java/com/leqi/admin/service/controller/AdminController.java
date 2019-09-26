package com.leqi.admin.service.controller;

import com.leqi.admin.service.entity.Admin;
import com.leqi.admin.service.service.AdminService;
import com.leqi.common.core.Result;
import com.leqi.common.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author lwep
 * @dareTime 2019/9/4 16:19
 */
@RestController
@RequestMapping("/admin")

public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 获取管理员列表
     * @return
     */
    @GetMapping
    public Result getList(){
        return Result.ok(adminService.getList());
    }


    /**
     * 添加管理员
     * @param admin

     * @return
     */
    @PostMapping
    public Result add(@RequestBody Admin admin, HttpServletRequest httpServletRequest) {
        String token = "";
        if(token.equals("a745d6c75e354b6876afdaf26fffd81a")) {
            if (adminService.add(admin)) {
                return Result.ok("添加成功");
            }
            return Result.fail("添加失败");
        }
        return Result.fail("没有权限");
    }

    //获取菜单接口，根据不同角色来
    @RequestMapping("test")
    public String getAdmin(){
        RedisUtils redisUtils = new RedisUtils();
        redisUtils.setRedisTemplate(redisTemplate);
        String username = redisUtils.get("current_user").toString();
        return username;
    }
}
