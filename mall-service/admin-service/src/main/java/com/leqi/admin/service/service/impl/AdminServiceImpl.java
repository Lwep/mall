package com.leqi.admin.service.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.leqi.admin.service.entity.Admin;
import com.leqi.admin.service.mapper.AdminMapper;
import com.leqi.admin.service.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lwep
 * @dareTime 2019/8/31 9:31
 */
@Slf4j
@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminMapper adminMapper;

    @Override
    public List<Admin> getList() {
        QueryWrapper<Admin> queryWrapper=new QueryWrapper<>();
        return adminMapper.selectList(queryWrapper);
    }

    @Override
    public boolean add(Admin admin) {
        return false;
    }
}
