package com.springcloud.mapper;

import com.springcloud.entity.TOrder;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Linshuiqiao
 * @InterfaceName: OrderMapper
 * @description: TODO
 * @date 2019年08月17日 23:27
 * @version: 1.0
 **/
@Repository
public interface OrderMapper {

    @Select("select * from t_order where id = #{id}")
    TOrder findById(Long id);

    @Select("select * from t_order")
    List<TOrder> findAll();

}
