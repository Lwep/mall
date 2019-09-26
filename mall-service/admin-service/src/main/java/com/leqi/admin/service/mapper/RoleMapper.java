package com.leqi.admin.service.mapper;

import com.leqi.admin.service.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.leqi.admin.service.vo.RoleVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Lwep
 * @since 2019-09-07
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {
    List<RoleVO> getRolesByUsername(String username);
}
