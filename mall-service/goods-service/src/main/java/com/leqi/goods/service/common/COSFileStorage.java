package com.leqi.goods.service.common;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Date;


/**
 * @author lwep
 * @dareTime 2019/9/6 15:28
 */
@Component
public class COSFileStorage {
    // 1 初始化用户身份信息(secretId,secretKey)
    private static String secretId = "AKIDSufEcZ2UDlGP4eEXhfZhhYGoBNYYRJPl";
    private static String secretKey = "JQM7hFg7uVwBMQgmhMrRE7oLteFcrycg";

    public COSClient getCosClient(){
        COSCredentials cred = new BasicCOSCredentials(secretId,secretKey);
        // 2 设置 bucket 的区域, COS 地域的简称请参照
        // https://cloud.tencent.com/document/product/436/6224
        // clientConfig 中包含了设置 region, https(默认 http),
        // 超时, 代理等 set 方法, 使用可参见源码或者常见问题 Java SDK 部分。
        Region region = new Region("ap-beijing");
        ClientConfig clientConfig = new ClientConfig(region);
        COSClient cosClient = new COSClient(cred,clientConfig);
        return  cosClient;
    }

    public String fileUpload(){
        // 指定要上传的文件
        File localFile = new File("G:\\eee.jpg");
        // 指定要上传到的存储桶
        String bucketName = "lwep-1300175355";
        // 指定要上传到 COS 上对象键
        String key = new Date().toString()+".jpg";
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, localFile);
        PutObjectResult putObjectResult = this.getCosClient().putObject(putObjectRequest);

        return "";
    }


}
