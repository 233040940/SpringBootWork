package com.example.springboot;

import java.io.Serializable;

public class ResponseResult<T> implements Serializable {

    private Integer code;    //返回代码
    private String message;   //返回信息
    private  T t;            //详细数据

    public ResponseResult(Integer code, String message, T t) {
        this.code = code;
        this.message = message;
        this.t = t;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    @Override
    public String toString() {
        return "ResponseResult{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", t=" + t +
                '}';
    }
}
