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

    public static <T> Result<T> SUCCEED(T object) {
        Result<T> result = new Result<T>();
        result.data = object;
        result.code = 1;
        return result;
    }

    public Result() {
    }
}
