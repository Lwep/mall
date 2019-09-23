package com.leqi.order.service.service.impl;

import com.leqi.order.service.entity.Details;
import com.leqi.order.service.entity.GoodsVO;
import com.leqi.order.service.feign.GoodsFeign;
import com.leqi.order.service.mapper.DetailsMapper;
import com.leqi.order.service.service.DetailsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.leqi.order.service.vo.DetailsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lwep
 * @since 2019-09-19
 */
@Service
public class DetailsServiceImpl extends ServiceImpl<DetailsMapper, Details> implements DetailsService {
    @Autowired
    private GoodsFeign goodsFeign;

    @Override
    public List<DetailsVO> getDetailsList() {
        List<Details> detailsList = this.list();
        List<DetailsVO> detailsVOList = new ArrayList<>();
        for (Details details:detailsList){
            DetailsVO detailsVO = new DetailsVO();
            detailsVO.setOrderSn(details.getOrderSn());
            GoodsVO goodsVO =goodsFeign.getGoods(details.getGoodsId());
            detailsVO.setGoodsName(goodsVO.getGoodsName());
            detailsVOList.add(detailsVO);
        }
        return detailsVOList;
    }
}
