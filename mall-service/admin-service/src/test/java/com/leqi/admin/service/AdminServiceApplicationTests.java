package com.leqi.admin.service;

import com.leqi.common.utils.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.Serializable;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class AdminServiceApplicationTests {
    @Autowired
    private RedisTemplate<String, Serializable> redisTemplate;

    @Test
    public void contextLoads() {
        RedisUtils redisUtils = new RedisUtils();
        redisUtils.setRedisTemplate(redisTemplate);
        log.info(redisTemplate.toString());
        redisUtils.set("qwe", "123");
    }


}
