package com.nifei.commons;


public enum ResultCode {

    SUCCESS(200,"请求成功"),
    PARAM_BIND_FAIL(400,"参数绑定失败"),
    REQUEST_FORBIDDEN(403,"请求被拒绝，权限不够"),
    RESOURCE_NOT_FIND(404,"请求路径未找到"),
    SERVER_ERROR(500,"服务器异常"),
    USERNAME_OR_PASSWORD_ERROR(9001,"用户名或者密码错误"),
    SYSTEM_CODE_ERROR(9002,"验证码错误");


    public Integer code;
    public String msg;

    ResultCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
