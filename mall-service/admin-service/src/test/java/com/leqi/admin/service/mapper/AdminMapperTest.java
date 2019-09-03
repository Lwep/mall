package com.leqi.admin.service.mapper;

import com.leqi.admin.service.AdminServiceApplicationTests;
import com.leqi.admin.service.entity.Admin;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * @author lwep
 * @dareTime 2019/9/3 16:42
 */
@Slf4j
public class AdminMapperTest extends AdminServiceApplicationTests {
    @Resource
    private AdminMapper adminMapper;
    @Test
    public void insertAdmin() {
        Admin admin = new Admin();
        admin.setAdmin_id(787L);
        admin.setAdmin_username("adad");
        adminMapper.insertAdmin(admin);
    }
}