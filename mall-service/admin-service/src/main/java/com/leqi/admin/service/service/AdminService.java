package com.leqi.admin.service.service;

import com.leqi.admin.service.entity.Admin;

import java.util.List;

/**
 * @author lwep
 * @dareTime 2019/8/31 9:30
 */
public interface AdminService {
    List<Admin> getList();
    boolean add(Admin admin);
}
