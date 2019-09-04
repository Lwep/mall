package com.leqi.admin.service.mapper.handler;

import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author lwep
 * @dareTime 2019/9/4 10:41
 */
@Component
@Slf4j
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("创建时间---"+ JSONArray.toJSONString(metaObject));
        this.setInsertFieldValByName("createTime", LocalDateTime.now(),metaObject);

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setInsertFieldValByName("loginTime", LocalDateTime.now(),metaObject);
    }
}
