package com.leqi.admin.service.service;

import com.leqi.admin.service.entity.Admin;
import com.leqi.admin.service.request.LoginRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lwep
 * @dareTime 2019/9/4 15:45
 */
public interface AdminService {
    List<Admin> getList();
    boolean add(Admin admin);

    Admin login(LoginRequest loginRequest);
}
