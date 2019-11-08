package com.leqi.goods.service.service;

import com.leqi.goods.service.entity.Goods;
import com.baomidou.mybatisplus.extension.service.IService;
import io.swagger.models.auth.In;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lwep
 * @since 2019-09-11
 */
public interface GoodsService extends IService<Goods> {




    List<Goods> getGoodsForCatagory(Long cid);
    /**
     * 获取商品列表
     * @return
     */
    List<Goods> getList();

    /**
     * 添加商品
     * @param goods
     * @return
     */
    boolean add(Goods goods);



    // boolean updateGoods(String goodsId);

}
