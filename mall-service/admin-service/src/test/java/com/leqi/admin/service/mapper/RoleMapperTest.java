package com.leqi.admin.service.mapper;

import com.alibaba.fastjson.JSON;
import com.leqi.admin.service.AdminServiceApplicationTests;
import com.leqi.admin.service.vo.RoleVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author lwep
 * @dareTime 2019/9/25 16:45
 */
@Slf4j
public class RoleMapperTest  extends AdminServiceApplicationTests {
    @Resource
    private RoleMapper roleMapper;

    @Test
    public void getRolesByUsername() {
        List<RoleVO> list = roleMapper.getRolesByUsername("admin002");
        log.info(JSON.toJSONString(list));
    }
}