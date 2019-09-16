package com.leqi.admin.service.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.leqi.admin.service.entity.Role;
import com.leqi.admin.service.request.RoleRequest;
import com.leqi.admin.service.service.RoleService;
import com.leqi.common.core.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Lwep
 * @since 2019-09-07
 */
@RestController
@RequestMapping("/admin/role")
@Slf4j

public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping
    public Result getPageList(RoleRequest roleRequest){
        Page page = new Page<>(roleRequest.getCurrent(), roleRequest.getSize());
        IPage<Role> iPage = roleService.page(page);
        return Result.ok(iPage);
    }

    @GetMapping("{id}")
    public Result batch(@PathVariable("id") Long id) {
        Role role=roleService.getById(id);
        return Result.ok(role);
    }

    @PostMapping
    public Result add(@RequestBody  Role role) {
        if(roleService.save(role)){
            return Result.ok("添加成功");
        }
        return Result.fail("添加失败");
    }

    @PutMapping
    public Result update(@RequestBody  Role role) {
        UpdateWrapper<Role> updateWrapper=new UpdateWrapper<>();
        updateWrapper.eq("id",role.getId());
        if(roleService.update(role,updateWrapper)){
            return Result.ok("修改成功");
        }
        return Result.fail("修改失败");
    }

    @DeleteMapping("{id}")
    public Result delete(@PathVariable("id") String id) {
        if(roleService.removeById(id)){
            return Result.ok("删除成功");
        }
        return Result.fail("删除失败");
    }

    @DeleteMapping("batch")
    public Result batch(@RequestBody List<String> ids) {
        log.info(JSON.toJSONString(ids));
        if(roleService.removeByIds(ids)){
            return Result.ok("删除成功");
        }
        return Result.fail("删除失败");
    }
}
