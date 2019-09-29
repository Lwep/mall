package com.leqi.goods.service.common;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.io.File;
import java.io.InputStream;
import java.util.Date;
import java.util.UUID;


/**
 * @author lwep
 * @dareTime 2019/9/6 15:28
 */
@Component

public class COSFileStorage {
    // 1 初始化用户身份信息(secretId,secretKey)
    private static String secretId = "AKIDSufEcZ2UDlGP4eEXhfZhhYGoBNYYRJPl";
    private static String secretKey = "JQM7hFg7uVwBMQgmhMrRE7oLteFcrycg";
    private static String bucketName = "lwep-1300175355";
    private static String regionName = "ap-beijing";

    /**
     * 连接cos服务
     * @return
     */
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

    /**
     * 本地上传
     * @param path
     * @param extName
     * @return
     */
    public String fileUpload(String path,String extName){
        // 指定要上传的文件
        File localFile = new File(path);
        // 指定要上传到 COS 上对象键
        UUID uuid = UUID.randomUUID();
        String key =uuid.toString().replace("-", "") + extName;
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, localFile);
        PutObjectResult putObjectResult = this.getCosClient().putObject(putObjectRequest);
        String imagePath = "https://" + bucketName + ".cos" + regionName + ".myqcloud.com/" + key;
        return imagePath;

    }


    /**
     *
     * @param input
     * @param extname
     * @return
     */
    public String fileUpload(InputStream input, String extname) {
        // 指定要上传到 COS 上对象键
        UUID uuid = UUID.randomUUID();
        String key = uuid.toString().replace("-", "") + extname;
        ObjectMetadata objectMetadata = new ObjectMetadata();
        // 设置 Content type, 默认是 application/octet-stream
        objectMetadata.setContentType("image/jpeg");
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, input, objectMetadata);
        PutObjectResult putObjectResult = this.getCosClient().putObject(putObjectRequest);
        String imagePath = "https://" + bucketName + ".cos." + regionName + ".myqcloud.com/" + key;
        return imagePath;
    }






}
