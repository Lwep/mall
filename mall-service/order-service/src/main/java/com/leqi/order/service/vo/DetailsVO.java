package com.leqi.order.service.vo;

import lombok.Data;

/**
 * @author lwep
 * @dareTime 2019/9/19 10:37
 */
@Data
public class DetailsVO {

    /**
     * 订单id
     */
    private Long id;

    /**
     * 订单编号
     */
    private String orderSn;

    /**
     * 商品名称
     */
    private String goodsName;


    /**
     * 订单数量
     */
    private Integer number;
}
