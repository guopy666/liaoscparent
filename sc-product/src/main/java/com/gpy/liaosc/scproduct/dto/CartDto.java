package com.gpy.liaosc.scproduct.dto;

import lombok.Data;

/**
 * @ClassName CartDto
 * @Description 购物车
 * @Author guopy
 * @Date 2020/9/2 22:24
 */
@Data
public class CartDto {

    private String productId;
    //商品数量
    private Integer productQuantity;

}
