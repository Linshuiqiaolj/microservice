package com.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @className: TOrder
 * @description: TODO
 * @author Linshuiqiao
 * @date 2019年08月17日 10:24
 * @version: 1.0
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class TOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id; // 主键id
    private String name; // 商品名称
    private Double price; // 商品价格
    private String dbSource; // 所存的数据库

}
