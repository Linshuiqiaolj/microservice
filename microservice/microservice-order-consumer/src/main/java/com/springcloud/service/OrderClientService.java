package com.springcloud.service;

import com.springcloud.conf.OrderClientServiceFallbackFactory;
import com.springcloud.entity.TOrder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author Linshuiqiao
 * @ClassName: OrderClientService
 * @description: feign客户端
 * @date 2019年08月18日 17:43
 * @version: 1.0
 **/
//@FeignClient(value = "MICROSERVICE-ORDER")
@FeignClient(value = "MICROSERVICE-ORDER", fallbackFactory = OrderClientServiceFallbackFactory.class)
public interface OrderClientService {

    @GetMapping("/provider/order/get/{id}")
    TOrder getOrder(@PathVariable(value = "id") Long id);

    @GetMapping("/provider/order/get/list")
    List<TOrder> getAll();

}
