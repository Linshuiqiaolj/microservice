package com.springcloud.conf;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RetryRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Linshuiqiao
 * @ClassName: RestTmplateConfig
 * @description: TODO
 * @date 2019年08月17日 23:37
 * @version: 1.0
 **/
@Configuration
public class RestTemplateConfig {

    /**
     * @auther: Linshuiqiao
     * @description:
     * @date: 2019-08-18 0018 14:28
     * '@LoadBalanced'注解表示使用Ribbon实现客户端负载均衡
     * @return: 
     */
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    public IRule myRule() {
        // 指定重试策略：轮询相关策略
        return new RetryRule();
    }

}
