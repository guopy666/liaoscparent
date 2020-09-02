package com.gpy.liaosc.scorder.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName CartDto
 * @Description 购物车
 * @Author guopy
 * @Date 2020/9/2 22:24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDto {

    private String productId;
    //商品数量
    private Integer productQuantity;


}
