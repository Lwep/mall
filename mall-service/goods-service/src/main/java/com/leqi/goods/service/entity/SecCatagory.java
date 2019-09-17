package com.leqi.goods.service.entity;

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
 * @since 2019-09-17
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("goods_sec_catagory")
public class SecCatagory extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private Long brandId;

    private String secCatagoryName;




}
