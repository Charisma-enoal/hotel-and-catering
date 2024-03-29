package com.murphy.gee.common.entity;

public enum MurphyResponseCode {
    //成功
    SUCCESS(200),

    // 失败
    FAIL(400),

    // 未认证（签名错误）
    UNAUTHORIZED(401),

    // 接口不存在
    NOT_FOUND(404),

    // 服务器内部错误
    INTERNAL_SERVER_ERROR(500),

    // 后台校验错误
    VALIDATE_ERROR(-1);

    public int code;

    MurphyResponseCode(int code){
        this.code = code;
    }
}
