package com.leqi.admin.service.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.leqi.admin.service.AdminServiceApplicationTests;
import com.leqi.admin.service.entity.Admin;
import com.leqi.admin.service.vo.MenuVO;
import com.leqi.common.utils.RedisUtils;
import lombok.extern.slf4j.Slf4j;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * @author lwep
 * @dareTime 2019/9/4 15:51
 */
@Slf4j
public class AdminServiceTest extends AdminServiceApplicationTests {
    @Autowired
    private AdminService adminService;

    @Test
    public void save(){
        Admin admin = new Admin();
        admin.setUsername("QQQ");
        admin.setPassword("123456");
        adminService.add(admin);
    }

    @Test
    public void getPage() {
        IPage<Admin> iPage=new Page<>(1,10);
        IPage<Admin>  page=adminService.page(iPage);
        log.info(JSON.toJSONString(page));
    }

    @Test
    public void contextLoads(){
        RedisUtils redisUtils = new RedisUtils();
        redisUtils.set("qwe","123");
    }


    @Test
    public void getMenusByUsername(){
        List<MenuVO> list = adminService.getMenusByUsername("admin002");
        log.info(JSONArray.toJSONString(list));

    }
}