package com.leqi.admin.service.controller;


import com.leqi.admin.service.service.AdminService;
import com.leqi.admin.service.service.MenuService;
import com.leqi.admin.service.vo.MenuVO;
import com.leqi.admin.service.vo.RouterVO;
import com.leqi.common.core.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Lwep
 * @since 2019-09-25
 */
@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private MenuService menuService;

    @GetMapping("{username}")
    public Result<List<MenuVO>> getMenus(@PathVariable("username") String username) {
        return Result.ok(adminService.getMenusByUsername(username));
    }

    @GetMapping("router/{username}")
    public Result<List<RouterVO>> getRouter(@PathVariable("username") String username) {
        return Result.ok(menuService.getRouter(username));
    }

}
