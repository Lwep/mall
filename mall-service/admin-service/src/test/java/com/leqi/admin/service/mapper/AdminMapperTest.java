package com.leqi.admin.service.mapper;

import com.leqi.admin.service.AdminServiceApplicationTests;
import com.leqi.admin.service.entity.Admin;
import org.junit.Test;

import javax.annotation.Resource;



/**
 * @author lwep
 * @dareTime 2019/9/2 15:48
 */
public class AdminMapperTest extends AdminServiceApplicationTests {

    @Resource
    private AdminMapper adminMapper;

    @Test
    public void insertAdmin() {
        Admin admin = new Admin();
        admin.setId(8847L);
        admin.setUsername("qwe");
        adminMapper.insertAdmin(admin);
    }
}