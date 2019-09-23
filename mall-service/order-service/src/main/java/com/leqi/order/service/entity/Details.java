package com.leqi.order.service.entity;

import com.leqi.common.core.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author lwep
 * @since 2019-09-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("order_details")
public class Details extends BaseEntity {


    private String orderSn;

    private Long goodsId;

    private String number;

    private String payment;


}
