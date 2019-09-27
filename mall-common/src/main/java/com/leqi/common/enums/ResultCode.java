package com.leqi.common.enums;

/**
 * @author lwep
 * @dareTime 2019/9/27 10:08
 */
public enum ResultCode {
    SERVER_ERROR("5000", "服务器错误"),
    PARAM_CHECK_ERROR("6000", "请求参数错误");

    private final String code;
    private final String message;

    ResultCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
    public String getCode() {
        return this.code;
    }

}
