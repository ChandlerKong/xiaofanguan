package com.xiaofanguan.server.common;

import lombok.Data;

@Data
public class ResponseResult<T> {
    private int code; // 状态码
    private String message; // 返回信息
    private T data; // 返回数据

    public ResponseResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    // 成功响应
    public static <T> ResponseResult<T> success(T data) {
        return new ResponseResult<>(200, "成功", data);
    }

    public static <T> ResponseResult<T> success() {
        return new ResponseResult<>(200, "成功", null);
    }



    // 成功响应
    public static <T> ResponseResult<T> ok(T data) {
        return new ResponseResult<>(200, "成功", data);
    }

    // 失败响应
    public static <T> ResponseResult<T> error(int code, String message) {
        return new ResponseResult<>(code, message, null);
    }
    // 失败响应
    public static <T> ResponseResult<T> error(String message) {
        return new ResponseResult<>(500, message, null);
    }
}