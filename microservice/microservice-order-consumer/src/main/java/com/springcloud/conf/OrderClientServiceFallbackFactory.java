package com.springcloud.conf;

import com.springcloud.entity.TOrder;
import com.springcloud.service.OrderClientService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Linshuiqiao
 * @ClassName: OrderClientServiceFallbackFactory
 * @description: 统一处理熔断
 * OrderClientService是Feign接口，所有访问都会走feign接口
 * @date 2019年08月18日 18:57
 * @version: 1.0
 **/
@Component
public class OrderClientServiceFallbackFactory implements FallbackFactory<OrderClientService> {
    @Override
    public OrderClientService create(Throwable throwable) {
        return new OrderClientService() {

            /**
             * 当订单服务的getOrder()方法出异常后的熔断处理方法
             * @param id id
             * @return 返回信息
             */
            @Override
            public TOrder getOrder(Long id) {
                return new TOrder(id, "未找到该ID的结果", 0d, "No this datasource");
            }

            @Override
            public List<TOrder> getAll() {
                return null;
            }
        };
    }
}
