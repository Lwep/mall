package com.leqi.user.service.mapper.handler;

import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
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
