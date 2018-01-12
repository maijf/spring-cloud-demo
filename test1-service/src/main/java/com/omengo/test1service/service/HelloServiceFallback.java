package com.omengo.test1service.service;

import com.omengo.test1service.protocol.RequestData;
import com.omengo.test1service.protocol.ResponseData;
import org.springframework.stereotype.Component;

@Component
public class HelloServiceFallback implements HelloService{

    @Override
    public String hello1() {
        return "hello1错误";
    }

    @Override
    public String hello2(String name) {
        return "hello2错误";
    }

    @Override
    public ResponseData hello3(RequestData requestData) {
        ResponseData responseData = new ResponseData();
        requestData.setTest1(0);
        requestData.setTest2("hello3错误");
        return responseData;
    }
}