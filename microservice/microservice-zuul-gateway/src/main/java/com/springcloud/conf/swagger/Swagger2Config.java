package com.springcloud.conf.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Linshuiqiao
 * @ClassName: Swagger2Config
 * @description: TODO
 * @date 2019年08月19日 21:29
 * @version: 1.0
 **/
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("说明文档")
                .description("接口说明文档")
                .termsOfServiceUrl("")
                .contact(new Contact("Ben","ben@foxmail.com","ben@foxmail.com"))
                .version("1.0")
                .build();
    }

}
