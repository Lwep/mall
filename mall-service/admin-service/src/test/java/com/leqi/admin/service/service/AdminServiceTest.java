package com.leqi.admin.service.service;

import com.alibaba.fastjson.JSONArray;
import com.leqi.admin.service.AdminServiceApplicationTests;
import com.leqi.admin.service.entity.Admin;
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
    public void getList() {
        List<Admin> adminList = adminService.getList();
        log.info(JSONArray.toJSONString(adminList));
    }
}