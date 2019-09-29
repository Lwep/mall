package com.leqi.admin.service.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.leqi.admin.service.entity.Admin;
import com.leqi.admin.service.request.LoginRequest;
import com.leqi.admin.service.vo.MenuVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lwep
 * @dareTime 2019/9/4 15:45
 */
public interface AdminService  extends IService<Admin> {
    List<Admin> getList();

    boolean add(Admin admin);

    Admin login(LoginRequest loginRequest);

    /**
     * 通过用户名获取菜单
     * @param username
     * @return
     */
    List<MenuVO> getMenusByUsername(String username);
}
