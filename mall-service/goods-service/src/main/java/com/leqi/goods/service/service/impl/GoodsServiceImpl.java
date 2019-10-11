package com.leqi.goods.service.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.leqi.goods.service.entity.Goods;
import com.leqi.goods.service.mapper.GoodsMapper;
import com.leqi.goods.service.service.GoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lwep
 * @since 2019-09-11
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {
    @Resource
    private GoodsMapper goodsMapper;


    /**
     * 获取商品列表
     * @return
     */
    @Override
    public List<Goods> getList() {
        QueryWrapper<Goods> queryWrapper = new QueryWrapper<>();
        return goodsMapper.selectList(queryWrapper);
    }

    /**
     * 添加商品
     * @param goods
     * @return
     */
    @Override
    public boolean add(Goods goods) {
        if(goodsMapper.insert(goods)>0){
            return true;
        }
        return false;
    }
}
