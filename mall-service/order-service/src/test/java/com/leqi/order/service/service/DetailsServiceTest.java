package com.leqi.order.service.service;

import com.alibaba.fastjson.JSON;
import com.leqi.order.service.OrderServiceApplicationTests;
import com.leqi.order.service.entity.Details;
import com.leqi.order.service.vo.DetailsVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author lwep
 * @dareTime 2019/9/19 10:17
 */
@Slf4j
public class DetailsServiceTest extends OrderServiceApplicationTests {

    @Autowired
    DetailsService detailsService;

    @Test
    public void save(){
        Details details = new Details();
        details.setGoodsId(1174238964387762178L);
        details.setOrderSn("1313");
        details.setNumber("10");
        details.setPayment("56445");
        detailsService.save(details);
    }

    @Test
    public void getDetails(){
        List<DetailsVO> detailsVOList = detailsService.getDetailsList();
        log.info(JSON.toJSONString(detailsVOList));
    }


}