package com.leqi.goods.service.service;

import com.alibaba.fastjson.JSON;
import com.leqi.goods.service.GoodsServiceApplicationTests;
import com.leqi.goods.service.entity.Category;
import com.leqi.goods.service.vo.CategoryVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author lwep
 * @dareTime 2019/9/11 16:05
 */
@Slf4j
public class CategoryServiceTest extends GoodsServiceApplicationTests {
    @Autowired
    private CatagoryService catagoryService;

    @Test
    public void save(){
        Category category = new Category();
        category.setCatagoryName("NIKE");
        category.setParentId(1173849633726734338L);
        catagoryService.save(category);
    }

    @Test
    public void testList(){
        List<CategoryVO> list = catagoryService.getList();
        log.info(JSON.toJSONString(list));
    }
}