package com.springcloud.service.impl;

import com.springcloud.entity.TOrder;
import com.springcloud.mapper.OrderMapper;
import com.springcloud.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Linshuiqiao
 * @ClassName: OrderServiceImpl
 * @description: TODO
 * @date 2019年08月17日 23:25
 * @version: 1.0
 **/
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper mapper;

    @Override
    public TOrder findById(Long id) {
        return mapper.findById(id);
    }

    @Override
    public List<TOrder> findAll() {
        return mapper.findAll();
    }
}
