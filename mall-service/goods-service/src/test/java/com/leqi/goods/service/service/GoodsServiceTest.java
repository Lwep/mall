package com.leqi.goods.service.service;

import com.leqi.goods.service.GoodsServiceApplicationTests;
import com.leqi.goods.service.entity.Goods;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @author lwep
 * @dareTime 2019/9/11 11:18
 */
@Slf4j
public class GoodsServiceTest  extends GoodsServiceApplicationTests {

    @Autowired
    private GoodsService goodsService;

    @Test
    public void save(){
        Goods goods = new Goods();
        goods.setGoodsName("P30");
        goods.setGoodsStock("1200");
        goods.setGoodsPrice("9999");
        goods.setGoodsBrand(1171701352259182593L);
        goodsService.save(goods);

    }


}