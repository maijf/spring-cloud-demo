package com.omengo.zuulservice.fallback;

import com.google.gson.JsonObject;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Component
public class Test1ServiceFallbackProvider implements FallbackProvider {

    /**
     * 返回值表示需要针对此微服务做回退处理
     * return * or null 则针对全部
     *
     * @return
     */
    @Override
    public String getRoute() {
        return "test1-service";
    }

    @Override
    public ClientHttpResponse fallbackResponse() {
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.BAD_REQUEST;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return HttpStatus.BAD_REQUEST.value();
            }

            @Override
            public String getStatusText() throws IOException {
                return HttpStatus.BAD_REQUEST.getReasonPhrase();
            }

            @Override
            public void close() {
            }

            /**
             * 当微服务出现宕机后，客户端再请求时候就会返回 fallback 等字样的字符串提示；
             * <p>
             * 但对于复杂一点的微服务，我们这里就得好好琢磨该怎么友好提示给用户了；
             *
             * @return
             * @throws IOException
             */
            @Override
            public InputStream getBody() throws IOException {
                JsonObject jo = new JsonObject();
                jo.addProperty("code","0");
                jo.addProperty("message",getRoute() + " fallback");
                return new ByteArrayInputStream(jo.toString().getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                return headers;
            }
        };
    }

    @Override
    public ClientHttpResponse fallbackResponse(Throwable cause) {
        return this.fallbackResponse();
    }
}