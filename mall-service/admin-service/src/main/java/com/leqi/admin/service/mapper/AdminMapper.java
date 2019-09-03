package com.leqi.admin.service.mapper;

import com.leqi.admin.service.entity.Admin;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author lwep
 * @dareTime 2019/9/3 16:35
 */
@Mapper
public interface AdminMapper {
    int insertAdmin(Admin admin);
}
