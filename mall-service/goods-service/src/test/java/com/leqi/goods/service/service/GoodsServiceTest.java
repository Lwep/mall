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
        goods.setGoodsPrice("1333");
        goods.setGoodsStock("12345");
        goods.setGoodsName("iphone");
        goods.setCatagoryId(1173849483256131586L);
        goods.setGoodsBrand(1173850218496634881L);
        goods.setSecCatagoryId(1173852165513494530L);
        goods.setGoodsImg("adad");
        goods.setGoodsStatus(1);
        goodsService.save(goods);

    }


}