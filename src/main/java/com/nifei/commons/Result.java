package com.nifei.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {

    //状态码
    private Integer code;
    //状态消息
    private String msg;
    //返回结果
    private Object data;

    //统一的请求成功（无返回值）
    public static Result SUCCESS(){
        return new Result(ResultCode.SUCCESS.code,ResultCode.SUCCESS.msg);
    }

    //统一的请求成功（有返回值）
    public static Result SUCCESS(Object data){
        return new Result(ResultCode.SUCCESS.code,ResultCode.SUCCESS.msg,data);
    }

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(Integer code, Object data) {
        this.code = code;
        this.data = data;
    }

}
