package com.atguigu.springboot.service;


public class HelloService {

    private String msg = "service";

    public String say(){
        return msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
