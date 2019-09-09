package com.leqi.admin.service.controller;


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
    public Result getPageList(@RequestBody RoleRequest roleRequest){
        return  Result.ok("");
    }

    @PostMapping
    public Result add(){
        return Result.ok("");
    }

    @PutMapping
    public Result update(){
        return Result.ok("");
    }

    @DeleteMapping("{id}")
    public Result delete(@PathVariable("id") Long id){
        return Result.ok("");
    }

    @DeleteMapping("batch")
    public Result batch(@RequestBody List<Long> ids){
        return Result.ok("");
    }
}
