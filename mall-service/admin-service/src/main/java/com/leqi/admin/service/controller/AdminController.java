package com.leqi.admin.service.controller;

import com.leqi.admin.service.entity.Admin;
import com.leqi.admin.service.service.AdminService;
import com.leqi.common.core.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

//    @GetMapping
//    public List<Admin> getList(){
//        return adminService.getList();
//    }
    @GetMapping
    public Result getList(){
        return Result.ok(adminService.getList());
    }
    @PostMapping
    public Result add(@RequestBody Admin admin){
        if(adminService.add(admin)){
            return Result.ok("添加成功");
        }
        return Result.fail("添加失败");
    }
}
