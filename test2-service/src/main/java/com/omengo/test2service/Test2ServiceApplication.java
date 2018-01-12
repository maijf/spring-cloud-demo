package com.omengo.test2service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class Test2ServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Test2ServiceApplication.class, args);
	}
}
