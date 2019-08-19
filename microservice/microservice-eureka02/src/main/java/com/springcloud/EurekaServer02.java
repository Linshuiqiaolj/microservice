package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Linshuiqiao
 * @ClassName: EurekaServer02
 * @description: TODO
 * @date 2019年08月18日 14:12
 * @EnableEurekaServer 注解表示服务器端启动类，接受其他微服务注册进来
 * @version: 1.0
 **/
@SpringBootApplication
@EnableEurekaServer
public class EurekaServer02 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServer02.class, args);
    }

}
