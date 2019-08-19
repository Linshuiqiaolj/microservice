package com.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Linshuiqiao
 * @ClassName: OrderApplication
 * @description: TODO
 * @date 2019年08月18日 0:03
 * "@EnableEurekaClient" 服务启动后会自动注册到eureka服务中心
 * @version: 1.0
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
@MapperScan("com.springcloud.mapper")
public class Order02Application {

    public static void main(String[] args) {
        SpringApplication.run(Order02Application.class, args);
    }

}
