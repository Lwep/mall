package com.leqi.admin.service.service;

import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.leqi.admin.service.AdminServiceApplicationTests;
import com.leqi.admin.service.entity.Role;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author lwep
 * @dareTime 2019/9/7 15:41
 */
@Slf4j
public class RoleServiceTest  extends AdminServiceApplicationTests {
    @Autowired
    private RoleService roleService;
    @Test
    public void save(){
        Role role = new Role();
        role.setRolename("超级aa");
        UpdateWrapper<Role> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id",1170243078074777601L);
        roleService.update(role,updateWrapper);
    }
    @Test
    public void getOne(){
        Role role = roleService.getById(1170243078074777601L);
        log.info(JSONArray.toJSONString(role));
    }

    @Test
    public void getPage(){
        IPage<Role> iPage = new Page<>(1,3);
        IPage<Role>   page =  roleService.page(iPage);
        log.info(JSONArray.toJSONString(page));
    }

    @Test
    public void delete(){
        roleService.removeById(1170243078074777601L);

    }

    @Test
    public void batch(){
        List<Long> ids = new ArrayList<>();
        ids.add(1170243078074777601L);
        roleService.removeByIds(ids);

    }

}