package com.leqi.goods.service.controller;


import com.leqi.common.core.Result;
import com.leqi.goods.service.service.CatagoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lwep
 * @since 2019-09-11
 */
@RestController
@RequestMapping("/goods/catagory")
@Api(tags = {"商品分类API"})
public class CatagoryController {

    @Autowired
    private CatagoryService catagoryService;


    /**
     * 获取级联菜单关系
     * @return
     */
    @GetMapping
    @ApiOperation(value = "获取级联菜单关系", notes = "获取级联菜单关系", httpMethod = "GET")
    public Result getList(){
        return Result.ok(catagoryService.getList());
    }

}
