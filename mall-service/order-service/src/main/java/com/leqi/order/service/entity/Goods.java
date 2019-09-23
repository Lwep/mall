package com.leqi.order.service.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.leqi.common.core.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author lwep
 * @since 2019-09-11
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("goods_goods")
public class Goods extends BaseEntity {

    private String goodsName;

    private String goodsImg;

    private String goodsPrice;

    private String goodsStock;

    private Long catagoryId;

    private Long secCatagoryId;

    private Long goodsBrand;

    private Integer goodsStatus;




}
