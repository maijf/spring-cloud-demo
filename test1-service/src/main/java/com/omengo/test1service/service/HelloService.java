package com.omengo.test1service.service;

import com.omengo.test1service.protocol.RequestData;
import com.omengo.test1service.protocol.ResponseData;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//配置调用的服务实例名
@FeignClient(name = "test2-service", fallback = HelloServiceFallback.class)
public interface HelloService {

    @RequestMapping("/hello1")
    String hello1();

    @RequestMapping("/hello2")
    String hello2(@RequestParam(value="name") String name);

    @RequestMapping("/hello3")
    ResponseData hello3(@RequestBody RequestData requestData);
}