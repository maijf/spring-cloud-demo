package com.omengo.test2service.controller;

import com.google.gson.Gson;
import com.omengo.test2service.protocol.RequestData;
import com.omengo.test2service.protocol.ResponseData;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class HelloController {

    private Log log = LogFactory.getLog(getClass());

    @Value("${spring.application.name}")
    private String applicationName;
    @Value("${server.port}")
    private String serverPort;

    /**
     * 随机延迟
     * @return
     * @throws Exception
     */
    @RequestMapping("/hello1")
    public String hello1()throws Exception{
        long mi = Math.round(Math.random()*8000);
        log.info("hello1请求；睡眠"+mi);
        Thread.sleep(mi);
        return "这是hello1请求："+applicationName+":"+serverPort+"，睡眠"+mi;
    }

    /**
     * 测试url参数
     * @param name
     * @return
     * @throws Exception
     */
    @RequestMapping("/hello2")
    public String hello2(@RequestParam String name,HttpServletRequest request)throws Exception{
        log.info("hello2请求"+request.getMethod());
        return "这是hello2请求："+applicationName+":"+serverPort+"，请求数据name:"+name;
    }

    /**
     * 测试content-type=application/json请求参数
     * @param requestData
     * @return
     */
    @RequestMapping("/hello3")
    public ResponseData hello3(@RequestBody RequestData requestData, HttpServletRequest request){
        log.info("hello3请求"+request.getHeader("content-type")+"  "+request.getMethod());
        ResponseData responseData = new ResponseData();
        responseData.setCode(1);
        responseData.setMessage("这是hello3请求:"+applicationName+":"+serverPort+"，请求数据requestData:"+ new Gson().toJson(requestData));
        return responseData;
    }
}