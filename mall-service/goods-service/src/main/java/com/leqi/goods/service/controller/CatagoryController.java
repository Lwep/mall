package com.leqi.goods.service.controller;


import com.leqi.common.core.Result;
import com.leqi.goods.service.service.CatagoryService;
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

public class CatagoryController {

    @Autowired
    private CatagoryService catagoryService;


    /**
     * 获取级联菜单关系
     * @return
     */
    @GetMapping
    public Result getList(){
        return Result.ok(catagoryService.getList());
    }

}
