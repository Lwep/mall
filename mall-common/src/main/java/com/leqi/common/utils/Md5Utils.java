package com.leqi.common.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author lwep
 * @dareTime 2019/9/9 10:18
 */
public class Md5Utils {
    /**
     * 获取md5加密字符串
     * @param sign
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static String getMD5(byte[] sign) throws NoSuchAlgorithmException {

        MessageDigest md5 = MessageDigest.getInstance("MD5");

        byte[] md5Bytes = md5.digest(sign);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16)
                hexValue.append("0");
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString().toLowerCase();

    }
    /**
     *
     * 功能描述:
     * 获取 MD5字符串
     * @参  数: 原始字符串
     * @返  回: MD字符串
     */
    public static String getMD5String(String key) {
        String cacheKey;
        try {
            final MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(key.getBytes());
            cacheKey = bytesToHexString(digest.digest());
        } catch (NoSuchAlgorithmException e) {
            cacheKey = String.valueOf(key.hashCode());
        }
        return cacheKey;
    }

    private static String bytesToHexString(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(0xFF & bytes[i]);
            if (hex.length() == 1) {
                sb.append('0');
            }
            sb.append(hex);
        }
        return sb.toString();
    }
}
