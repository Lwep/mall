package com.leqi.goods.service.service.impl;


import com.alibaba.fastjson.JSON;
import com.leqi.goods.service.entity.Category;
import com.leqi.goods.service.mapper.CatagoryMapper;
import com.leqi.goods.service.service.CatagoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.leqi.goods.service.vo.CategoryVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author lwep
 * @since 2019-09-11
 */
@Service
@Slf4j
public class CatagoryServiceImpl extends ServiceImpl<CatagoryMapper, Category> implements CatagoryService {

    @Override
    public List<CategoryVO> getList() {
        List<CategoryVO> categoryVOS=new ArrayList<>();

        List<Category> categories = this.list();
        log.info("1111"+JSON.toJSONString(categories));

        for (Category category : categories) {
            if(category.getParentId()==0){
                CategoryVO categoryVO=new CategoryVO();
                categoryVO.setValue(category.getId().toString());
                categoryVO.setLabel(category.getCatagoryName());
                // 添加子数据
                List<CategoryVO> listTemp=this.getSubCategory(category.getId(),categories);
                if(listTemp.size()>0) {
                    categoryVO.setChildren(listTemp);
                }
                categoryVOS.add(categoryVO);
            }
        }
        return categoryVOS;
    }

    private   List<CategoryVO> getSubCategory(long id,List<Category> categories ){
        List<CategoryVO> categoryVOList=new ArrayList<>();
        for (Category categroy:categories) {
            // 如果
            if(id==categroy.getParentId()){
                CategoryVO categoryVO=new CategoryVO();
                categoryVO.setValue(categroy.getId().toString());
                categoryVO.setLabel(categroy.getCatagoryName());
                categoryVOList.add(categoryVO);
                List<CategoryVO> listTemp=getSubCategory(categroy.getId(),categories);
                if(listTemp.size()>0) {
                    // 添加子数据
                    categoryVO.setChildren(listTemp);
                }
            }
        }
        return categoryVOList;
    }


}
