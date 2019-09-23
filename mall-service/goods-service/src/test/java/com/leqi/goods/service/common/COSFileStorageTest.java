package com.leqi.goods.service.common;

import com.baomidou.mybatisplus.annotation.TableField;
import com.leqi.goods.service.GoodsServiceApplicationTests;
import com.qcloud.cos.COSClient;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @author lwep
 * @dareTime 2019/9/6 15:39
 */
@Slf4j

public class COSFileStorageTest extends GoodsServiceApplicationTests {
    @Autowired
    private COSFileStorage cosFileStorage;
    @Test
    public  void test(){
        COSClient cosClient=cosFileStorage.getCosClient();
//        cosFileStorage.fileUpload();
        log.info(cosClient.toString());
    }

    @Test
    public void getExt(){
        String path  = "adaa.jpg";
        log.info(path.substring(path.indexOf("."),path.length()));
    }
}