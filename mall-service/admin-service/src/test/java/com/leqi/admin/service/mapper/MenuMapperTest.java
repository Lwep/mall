package com.leqi.admin.service.mapper;

import com.alibaba.fastjson.JSON;
import com.leqi.admin.service.AdminServiceApplicationTests;
import com.leqi.admin.service.entity.Menu;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author lwep
 * @dareTime 2019/9/26 9:22
 */
@Slf4j
public class MenuMapperTest extends AdminServiceApplicationTests {
    @Resource
    private MenuMapper menuMapper;

    @Test
    public void getMenuByRoleId() {
       List<Menu> list= menuMapper.getMenuByRoleId(1173514415954227201L);
        log.info(JSON.toJSONString(list));
    }
}