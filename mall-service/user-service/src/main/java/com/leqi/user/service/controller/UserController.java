package com.leqi.user.service.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.leqi.common.core.Result;
import com.leqi.user.service.entity.User;
import com.leqi.user.service.request.UserRequest;
import com.leqi.user.service.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
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
@Api(value = "用户管理类")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 获取用户数据，分页显示
     * @param userRquest
     * @return
     */
    @GetMapping
    @ApiOperation(value = "获取用户并分页显示",notes = "获取对象分页显示")

    public Result getPageList(UserRequest userRquest) {
        Page page = new Page<>(userRquest.getCurrent(), userRquest.getSize());
        IPage<User> iPage = userService.page(page);
        return Result.ok(iPage);
    }

    /**
     * 获取单个用户
     * @param id
     * @return
     */
    @GetMapping("{id}")
    @ApiOperation(value = "获取单个用户",notes = "返回用户信息")

    public Result getOne(@PathVariable("id") Long id) {
        User user = userService.getById(id);
        return Result.ok(user);
    }

    /**
     * 增加用户
     * @param user
     * @return
     */
    @PostMapping
    @ApiOperation(value = "新增一个用户",notes = "新增后返回结果")
    public Result add(@RequestBody User user) {
        if (userService.save(user)) {
            return Result.ok("添加成功");
        }
        return Result.fail("添加失败");
    }

    /**
     * 修改用户
     * @param user
     * @return
     */
    @PutMapping
    @ApiOperation(value = "修改用户信息",notes = "根据id修改")
    public Result update(@RequestBody User user) {
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", user.getId());
        if (userService.update(user, updateWrapper)) {
            return Result.ok("修改成功");
        }
        return Result.fail("修改失败");
    }


    @DeleteMapping("{id}")
    @ApiOperation(value = "删除用户",notes = "根据id删除用户，返回结果")

    public Result delete(@PathVariable("id") String id) {
        if (userService.removeById(id)) {
            return Result.ok("删除成功");
        }
        return Result.fail("删除失败");
    }


    @DeleteMapping("batch")
    @ApiOperation(value = "批量删除用户",notes = "根据多个id删除用户，返回结果")
    public Result batch(@RequestBody List<String> ids) {
        log.info(JSON.toJSONString(ids));
        if (userService.removeByIds(ids)) {
            return Result.ok("删除成功");
        }
        return Result.fail("删除失败");
    }

}
