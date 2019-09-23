package com.leqi.order.service.feign;

import com.leqi.common.core.Result;
import com.leqi.order.service.entity.Goods;
import com.leqi.order.service.entity.GoodsVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author lwep
 * @dareTime 2019/9/19 10:46
 */
@Component
@FeignClient(value = "GOODS-SERVICE" ,path = "/goods/goods")
public interface GoodsFeign {
    @GetMapping("/{id}")
    GoodsVO getGoods(@PathVariable("id") Long id);
}
