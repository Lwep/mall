package com.leqi.common.utils;

/**
 * @author lwep
 * @dareTime 2019/9/20 10:48
 */
public class StringUtils {
    /**
     * 获取文件扩展名
     * @param fileName
     * @return
     */
    public  static String getFileExt(String fileName){
        return fileName.substring(fileName.indexOf("."));
    }
}
