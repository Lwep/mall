package com.leqi.admin.service.service;

import com.alibaba.fastjson.JSON;
import com.leqi.admin.service.AdminServiceApplicationTests;
import com.leqi.admin.service.vo.RoleVO;
import com.leqi.admin.service.vo.RouterVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author lwep
 * @dareTime 2019/9/27 16:02
 */
@Slf4j
public class MenuServiceTest  extends AdminServiceApplicationTests {

    @Autowired
    private MenuService menuService;
    @Test
    public void getRouter() {
        List<RouterVO> list = menuService.getRouter("admin002");
        log.info(JSON.toJSONString(list));

    }
}