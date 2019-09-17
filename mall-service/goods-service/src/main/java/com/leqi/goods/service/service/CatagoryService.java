package com.leqi.goods.service.service;

import com.leqi.goods.service.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;
import com.leqi.goods.service.vo.CategoryVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lwep
 * @since 2019-09-11
 */
public interface CatagoryService extends IService<Category> {

    List<CategoryVO> getList();
}
