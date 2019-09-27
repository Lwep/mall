package com.leqi.admin.service.controller;

import com.leqi.admin.service.entity.Admin;
import com.leqi.admin.service.service.AdminService;
import com.leqi.common.core.Result;
import com.leqi.common.utils.RedisUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * @author lwep
 * @dareTime 2019/9/4 16:19
 */
@RestController
@RequestMapping("/admin")
@Api(tags = {"管理员API"})
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

    @ApiOperation(value = "获取管理员数据列表", notes = "获取管理员数据列表", httpMethod = "GET")
    public Result getList(){
        return Result.ok(adminService.getList());
    }


    /**
     * 添加管理员
     * @param admin

     * @return
     */
    @PostMapping
    @ApiOperation(value = "添加管理员", notes = "添加管理员", httpMethod = "POST")
        public Result add(@RequestBody @Valid Admin admin) {

        if (adminService.add(admin)) {
            return Result.ok("添加成功");
        }
        return Result.fail("添加失败");

    }

    //获取菜单接口，根据不同角色来
    @GetMapping("test")
    @ApiOperation(value = "根据角色获取菜单列表", notes = "根据角色获取菜单列表", httpMethod = "GET")
    public String getAdmin(){
        RedisUtils redisUtils = new RedisUtils();
        redisUtils.setRedisTemplate(redisTemplate);
        String username = redisUtils.get("current_user").toString();
        return username;
    }
}
