package com.leqi.order.service.service;

import com.leqi.order.service.entity.Details;
import com.baomidou.mybatisplus.extension.service.IService;
import com.leqi.order.service.vo.DetailsVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lwep
 * @since 2019-09-19
 */
public interface DetailsService extends IService<Details> {

    List<DetailsVO> getDetailsList();
}
