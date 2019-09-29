package com.leqi.admin.service.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService  {
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

    //根据用户名查找角色
    @Override
    public List<MenuVO> getMenusByUsername(String username) {
        List<RoleVO> roles = roleMapper.getRolesByUsername(username);
        List<MenuVO> menuVOList=new ArrayList<>();
        for (RoleVO roleVO : roles) {
            List<Menu> lists = menuMapper.getMenuByRoleId(roleVO.getId());
            for (Menu menu:lists) {
                if(null!=menu&&null!=menu.getParentId()&&menu.getParentId()==0) {
                    MenuVO menuVO = new MenuVO();
                    menuVO.setId(menu.getId());
                    menuVO.setKey(menu.getId().toString());
                    menuVO.setTitle(menu.getMenuName());
                    menuVO.setIcon(menu.getIcon());
                    menuVO.setPath(menu.getPath());
                    menuVO.setChildren(this.getSubMenu(lists,menuVO));
                    // 添加一级菜单数据
                    menuVOList.add(menuVO);
                }
            }
        }
        return menuVOList;
    }

    /**
     * 获取子菜单
     * @param lists
     * @param menuVO
     * @return
     */
    private Set<MenuVO> getSubMenu( List<Menu> lists,  MenuVO menuVO ){
        Set<MenuVO> menuVOList=new HashSet<>();
        for (Menu menu0:lists) {
            if(menuVO.getId()==menu0.getParentId()){
                MenuVO menuVO0 = new MenuVO();
                menuVO0.setId(menu0.getId());
                menuVO0.setKey(menu0.getId().toString());
                menuVO0.setPath(menu0.getPath());
                menuVO0.setIcon(menu0.getIcon());
                menuVO0.setTitle(menu0.getMenuName());
                menuVOList.add(menuVO0);
                // 添加到集合
                Set<MenuVO> menuVOSet=this.getSubMenu(lists,menuVO0);
                menuVO0.setChildren(menuVOSet);
            }
        }
        return menuVOList;
    }
}
