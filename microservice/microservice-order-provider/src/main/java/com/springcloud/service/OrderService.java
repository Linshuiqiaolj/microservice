package com.springcloud.service;

import com.springcloud.entity.TOrder;

import java.util.List;

/**
 * @author Linshuiqiao
 * @InterfaceName: OrderService
 * @description: TODO
 * @date 2019年08月17日 23:11
 * @version: 1.0
 **/
public interface OrderService {

    TOrder findById(Long id);

    List<TOrder> findAll();

}
