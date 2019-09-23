package com.leqi.order.service.service.impl;

import com.leqi.order.service.entity.Order;
import com.leqi.order.service.mapper.OrderMapper;
import com.leqi.order.service.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lwep
 * @since 2019-09-19
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

}
