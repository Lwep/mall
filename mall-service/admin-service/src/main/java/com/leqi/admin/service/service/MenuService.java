package com.leqi.admin.service.service;

import com.leqi.admin.service.entity.Menu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.leqi.admin.service.vo.RouterVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Lwep
 * @since 2019-09-25
 */
public interface MenuService extends IService<Menu> {
    List<RouterVO> getRouter(String username);
}
