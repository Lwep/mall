package com.leqi.goods.service.service;

import com.leqi.goods.service.GoodsServiceApplicationTests;
import com.leqi.goods.service.entity.SecCatagory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @author lwep
 * @dareTime 2019/9/17 14:50
 */
@Slf4j
public class SecCategoryServiceTest extends GoodsServiceApplicationTests {
    @Autowired
    private SecCatagoryService secCatagoryService;

    @Test
    public void save(){
        SecCatagory secCatagory = new SecCatagory();
        secCatagory.setSecCatagoryName("手机");
        secCatagory.setBrandId(1173850218496634881L);
        secCatagoryService.save(secCatagory);
    }


}