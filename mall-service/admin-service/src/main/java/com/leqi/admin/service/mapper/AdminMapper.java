package com.leqi.admin.service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.leqi.admin.service.entity.Admin;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author lwep
 * @dareTime 2019/8/31 9:29
 */
@Mapper
public interface AdminMapper extends BaseMapper<Admin> {
    int insertAdmin(Admin admin);
}
