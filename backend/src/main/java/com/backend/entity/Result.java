package com.backend.entity;

import lombok.Data;

@Data
public class Result<T> {
    private Integer code;
    private String message;

    private T data;

    public Result(Integer code, String message,T data) {
        this.code=code;
        this.message=message;
        this.data=data;
    }

    public static Result ERR(Integer code,String message,Object data){
        return new Result(code,message,data);
    }

    public static Result SUCCEED(String message,Object data) {
        return new Result(200,message,data);
    }

}
