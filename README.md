# spring-cloud-demo
>zuul：10秒读取超时，重试一次； test1：4秒读取超时，重试一次
1. http://localhost:8090/test1/hello   (test1随机延迟20秒内)
2. http://localhost:8090/test1/hello1  (test1调用test2，test2随机延迟8秒内)
3. http://localhost:8090/test1/hello2  (get请求)
4. http://localhost:8090/test1/hello3  (post请求 content-Type=application/json)


## 注册服务中心
* 实例名：eureka-server
* 端口号：8000

## 配置中心
* 实例名：config-server
* 端口号：8001

## 链路追踪中心
* 实例名：zipkin-server
* 端口号：8002

## 断路器聚合监控服务
* 实例名：turbine-service
* 端口号：8003

## 网关路由服务
* 实例名：zuul-service
* 端口号：8090

## 消费(生产)者服务
* 实例名：test1-service
* 端口号：8010

## 生产者服务
* 实例名：test2-service
* 端口号：8020