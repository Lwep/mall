package com.leqi.order.service.mapper;

import com.leqi.order.service.entity.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lwep
 * @since 2019-09-19
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {

}
