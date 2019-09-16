package com.leqi.user.service.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.leqi.common.core.Result;
import com.leqi.user.service.entity.User;
import com.leqi.user.service.request.UserRequest;
import com.leqi.user.service.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Lwep
 * @since 2019-09-16
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public Result getPageList(UserRequest userRquest) {
        Page page = new Page<>(userRquest.getCurrent(), userRquest.getSize());
        IPage<User> iPage = userService.page(page);
        return Result.ok(iPage);
    }

    @GetMapping("{id}")
    public Result batch(@PathVariable("id") Long id) {
        User user = userService.getById(id);
        return Result.ok(user);
    }


    @PostMapping
    public Result add(@RequestBody User user) {
        if (userService.save(user)) {
            return Result.ok("添加成功");
        }
        return Result.fail("添加失败");
    }


    @PutMapping
    public Result update(@RequestBody User user) {
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", user.getId());
        if (userService.update(user, updateWrapper)) {
            return Result.ok("修改成功");
        }
        return Result.fail("修改失败");
    }


    @DeleteMapping("{id}")
    public Result delete(@PathVariable("id") String id) {
        if (userService.removeById(id)) {
            return Result.ok("删除成功");
        }
        return Result.fail("删除失败");
    }


    @DeleteMapping("batch")
    public Result batch(@RequestBody List<String> ids) {
        log.info(JSON.toJSONString(ids));
        if (userService.removeByIds(ids)) {
            return Result.ok("删除成功");
        }
        return Result.fail("删除失败");
    }

}
