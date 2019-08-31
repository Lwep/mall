package com.leqi.common.core;

import lombok.Data;

/**
 * @author lwep
 * @dareTime 2019/8/31 9:37
 */
@Data
public class Result<T> {
    private String code;
    private String message;
    private T data;


    /**
     * 构造函数
     */
    private Result(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    private Result(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static Result fail(String message) {
        return new Result("1111", message);
    }

    public static Result ok(String message) {
        return new Result("0000", message);
    }

    public static Result ok(Object data) {
        return new Result("0000", "success", data);
    }
}