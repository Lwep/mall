package com.leqi.admin.service.service.impl;

import com.alibaba.fastjson.JSON;
import com.leqi.admin.service.entity.Menu;
import com.leqi.admin.service.mapper.MenuMapper;
import com.leqi.admin.service.mapper.RoleMapper;
import com.leqi.admin.service.service.MenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.leqi.admin.service.vo.RoleVO;
import com.leqi.admin.service.vo.RouterVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Lwep
 * @since 2019-09-25
 */
@Service
@Slf4j
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {
    @Resource
    private RoleMapper roleMapper;
    @Resource
    private MenuMapper menuMapper;

    @Override
    public List<RouterVO> getRouter(String username) {
        // 1. 根据管理员登录名查找权限等级
        List<RoleVO> roles = roleMapper.getRolesByUsername(username);
        log.info(JSON.toJSONString("1--"+roles));
        List<RouterVO> routerVOList=new ArrayList<>();

        for (RoleVO roleVO : roles) {
            // 2. 通过权限等级获取菜单
            List<Menu> lists = menuMapper.getMenuByRoleId(roleVO.getId());
            log.info(JSON.toJSONString("3--"+lists));

            for (Menu menu:lists) {
                // 目录为空

                    RouterVO routerVO = new RouterVO();
                    routerVO.setName(menu.getName());
                    routerVO.setComponent(menu.getComponent());
                    routerVO.setPath(menu.getPath());
                    // 添加一级菜单数据
                    routerVOList.add(routerVO);

            }
        }
        return routerVOList;
    }
}
