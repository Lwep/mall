package com.leqi.goods.service.service;

import com.leqi.goods.service.GoodsServiceApplicationTests;
import com.leqi.goods.service.entity.Brand;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @author lwep
 * @dareTime 2019/9/11 16:23
 */
@Slf4j
public class BrandServiceTest  extends GoodsServiceApplicationTests {
    @Autowired
    private BrandService brandService;

    @Test
    public void save(){
        Brand brand = new Brand();
        brand.setBrandName("LINING");
        brand.setCatagoryId(1173849633726734338L);
        brandService.save(brand);
    }
}