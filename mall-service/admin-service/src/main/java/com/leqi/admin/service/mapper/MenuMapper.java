package com.leqi.admin.service.mapper;

import com.leqi.admin.service.entity.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Lwep
 * @since 2019-09-25
 */
@Mapper
public interface MenuMapper extends BaseMapper<Menu> {
    List<Menu> getMenuByRoleId(long roleId);


}
