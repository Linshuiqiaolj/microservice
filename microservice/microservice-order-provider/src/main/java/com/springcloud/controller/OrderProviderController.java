package com.springcloud.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.springcloud.entity.TOrder;
import com.springcloud.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Linshuiqiao
 * @ClassName: OrderProviderController
 * @description: TODO
 * @date 2019年08月17日 23:06
 * @version: 1.0
 **/
@RestController
@RequestMapping("/provider/order")
public class OrderProviderController {

    @Resource
    private OrderService orderService;

    @Resource
    private EurekaClient client;

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderProviderController.class);

    @GetMapping("/discovery")
    public Object discovery() {
        // 获取Eureka中所有的服务节点
        List<Application> applications = client.getApplications().getRegisteredApplications();
        if (applications != null) {
            for (Application application : applications) {
                // 对外暴露的服务名称
                String name = application.getName();
                // 只看订单服务信息
                if ("MICROSERVICE-ORDER".equals(name)) {
                    // 服务有多少个实例，比如订单服务可能部署了多个，有多个订单服务注册到了eureka
                    List<InstanceInfo> instances = application.getInstances();
                    LOGGER.info("所有的订单服务：{}", instances);
                    if (instances != null) {
                        for (InstanceInfo info : instances) {
                            LOGGER.info("服务id：{}", info.getInstanceId());
                            LOGGER.info("服务主机：{}", info.getHostName());
                            LOGGER.info("服务端口：{}", info.getPort());
                        }
                    }
                    return instances;
                }
            }
        }
        return null;
    }

    @GetMapping("/get/{id}")
    public TOrder getOrder(@PathVariable Long id) {
        return orderService.findById(id);
    }

    @GetMapping("/get/list")
    public List<TOrder> getAll() {
        System.out.println("1111111111111111");
        return orderService.findAll();
    }
}
