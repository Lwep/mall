package com.leqi.admin.service.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.leqi.admin.service.entity.Admin;
import com.leqi.admin.service.request.AdminRequest;
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
     *
     * @return
     */
    @GetMapping
    @ApiOperation(value = "获取管理员数据分页列表", notes = "获取管理员数据列表", httpMethod = "GET")
    public Result getPageList(AdminRequest adminRequest) {
        Page page = new Page<>(adminRequest.getCurrent(), adminRequest.getSize());
        IPage<Admin> iPage = adminService.page(page);
        return Result.ok(iPage);
    }


    /**
     * 添加管理员
     *
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
    public String getAdmin() {
        RedisUtils redisUtils = new RedisUtils();
        redisUtils.setRedisTemplate(redisTemplate);
        String username = redisUtils.get("current_user").toString();
        return username;
    }

    /**
     * 删除单个用户
     * @param id
     * @return
     */
    @DeleteMapping("{id}")
    @ApiOperation(value = "根据id删除单个管理员", notes = "根据id删除单个管理员", httpMethod = "DELETE")
    public Result delete(@PathVariable("id") String id){
        if(adminService.removeById(id)){
            return Result.ok("删除成功");
        }
        else
            return Result.fail("删除失败");
    }

    /**
     * 批量删除用户
     * @param ids
     * @return
     */
    @DeleteMapping("batch")
    @ApiOperation(value = "根据ids批量删除管理员", notes = "根据ids批量删除管理员", httpMethod = "DELETE")
    public Result batch(@RequestBody List<String> ids){
        if(adminService.removeByIds(ids)){
            return Result.ok("删除成功");
        }
        else
            return Result.fail("删除失败");
    }


}
