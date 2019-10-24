package com.leqi.order.service.feign;

import com.alibaba.fastjson.JSON;
import com.leqi.common.core.Result;
import com.leqi.order.service.OrderServiceApplicationTests;
import com.leqi.order.service.entity.GoodsVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @author lwep
 * @dareTime 2019/9/19 10:49
 */
@Slf4j
public class GoodsFeignTest extends OrderServiceApplicationTests {

    @Autowired
    private  GoodsFeign goodsFeign;

    @Test
    public void getGoods() {
        GoodsVO goodsVO = goodsFeign.getGoods(1181753145986985985L);
        log.info(JSON.toJSONString(goodsVO));
    }
}