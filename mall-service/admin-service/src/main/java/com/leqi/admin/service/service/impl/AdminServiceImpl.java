package com.leqi.admin.service.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.leqi.admin.service.entity.Admin;
import com.leqi.admin.service.entity.Menu;
import com.leqi.admin.service.mapper.AdminMapper;
import com.leqi.admin.service.mapper.MenuMapper;
import com.leqi.admin.service.mapper.RoleMapper;
import com.leqi.admin.service.request.LoginRequest;
import com.leqi.admin.service.service.AdminService;
import com.leqi.admin.service.vo.MenuVO;
import com.leqi.admin.service.vo.RoleVO;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author lwep
 * @dareTime 2019/9/4 15:45
 */
@Slf4j
@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminMapper adminMapper;
    @Resource
    private RoleMapper roleMapper;
    @Resource
    private MenuMapper menuMapper;


    @Override
    public List<Admin> getList() {
        QueryWrapper<Admin> queryWrapper = new QueryWrapper<>();
        return adminMapper.selectList(queryWrapper);
    }

    @Override
    public boolean add(Admin admin) {
        if(adminMapper.insert(admin)>0){
            return true;
        }
        return false;
    }

    @Override
    public Admin login(LoginRequest loginRequest) {
        QueryWrapper<Admin> queryWrapper = new QueryWrapper();
        queryWrapper.eq("username",loginRequest.getUsername());
        queryWrapper.eq("password",loginRequest.getPassword());
        Admin admin = adminMapper.selectOne(queryWrapper);
        if(null!=admin){
            return admin;
        }
        return null;
    }

    @Override
    public List<MenuVO> getMenusByUsername(String username) {
        List<RoleVO> roles= roleMapper.getRolesByUsername(username);
        Set<Menu> menus = new HashSet<>();
        for (RoleVO roleVO: roles) {
           List<Menu> lists =  menuMapper.getMenuByRoleId(roleVO.getId());
            for (Menu menu:lists) {
            menus.add(menu);
            }
        }
        return null;
    }
}
