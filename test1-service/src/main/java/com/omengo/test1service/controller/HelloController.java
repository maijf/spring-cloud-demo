package com.omengo.test1service.controller;

import com.omengo.test1service.protocol.RequestData;
import com.omengo.test1service.protocol.ResponseData;
import com.omengo.test1service.service.HelloService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private Log log = LogFactory.getLog(getClass());

    @Autowired
    private HelloService helloService;

    @RequestMapping("/hello")
    public String hello()throws Exception{
        long mi = Math.round(Math.random()*20000);
        log.info("hello请求;睡眠："+mi);
        Thread.sleep(mi);
        return "hello请求;睡眠："+mi;
    }

    @RequestMapping("/hello1")
    public String hello1(){
        log.info("hello1请求");
        return helloService.hello1();
    }

    @RequestMapping("/hello2")
    public String hello2(){
        log.info("hello2请求");
        return helloService.hello2("abc");
    }

    @RequestMapping("/hello3")
    public ResponseData hello3(){
        log.info("hello3请求");
        RequestData requestData = new RequestData();
        requestData.setTest1(1);
        requestData.setTest2("success");
        return helloService.hello3(requestData);
    }
}