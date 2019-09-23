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
@TableName("order_order")
public class Order extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String addressId;

    private String orderSn;

    private String orderStatus;



}
