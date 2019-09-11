package com.leqi.goods.service.service;

import com.leqi.goods.service.GoodsServiceApplicationTests;
import com.leqi.goods.service.entity.Catagory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @author lwep
 * @dareTime 2019/9/11 16:05
 */
@Slf4j
public class CatagoryServiceTest  extends GoodsServiceApplicationTests {
    @Autowired
    private CatagoryService catagoryService;

    @Test
    public void save(){
        Catagory catagory = new Catagory();
        catagory.setCatagoryName("手机");
        catagory.setParentId(null);
        catagoryService.save(catagory);
    }
}