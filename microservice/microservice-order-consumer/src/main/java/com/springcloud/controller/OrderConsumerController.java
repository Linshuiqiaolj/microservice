package com.springcloud.controller;

import com.springcloud.entity.TOrder;
import com.springcloud.service.OrderClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Linshuiqiao
 * @ClassName: OrderConsumerController
 * @description: TODO
 * @date 2019年08月17日 23:40
 * @version: 1.0
 **/
@RestController
@RequestMapping("/consumer/order")
public class OrderConsumerController {

    // 订单服务提供者模块的 url 前缀
//    private static final String ORDER_PROVIDER_URL_PREFIX = "http://localhost:8001";
//    private static final String ORDER_PROVIDER_URL_PREFIX = "http://MICROSERVICE-ORDER";
    @Resource
    private OrderClientService service;

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/get/{id}")
    public TOrder getOrder(@PathVariable Long id) {

//        return restTemplate.getForObject(ORDER_PROVIDER_URL_PREFIX + "/provider/order/get/" + id, TOrder.class);
        return service.getOrder(id);
    }

    @SuppressWarnings("unchecked")
    @GetMapping("/get/list")
    public List<TOrder> getAll() {
//        return restTemplate.getForObject(ORDER_PROVIDER_URL_PREFIX + "/provider/order/get/list", List.class);
        return service.getAll();
    }

}
