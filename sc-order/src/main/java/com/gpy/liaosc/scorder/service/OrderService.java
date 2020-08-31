package com.gpy.liaosc.scorder.service;

import com.gpy.liaosc.scorder.dto.OrderDto;

/**
 * @Description:
 * @author: guopy
 * @Date: 2020/8/1 22:18
 * @version: v1.0.0
 */
public interface OrderService {

    OrderDto createOrder(OrderDto orderDto);

}
