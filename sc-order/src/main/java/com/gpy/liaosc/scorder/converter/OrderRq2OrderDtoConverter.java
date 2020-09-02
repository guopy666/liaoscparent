package com.gpy.liaosc.scorder.converter;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.gpy.liaosc.scorder.constant.ResultEnum;
import com.gpy.liaosc.scorder.dto.OrderDto;
import com.gpy.liaosc.scorder.dto.OrderRq;
import com.gpy.liaosc.scorder.entity.OrderDetail;
import com.gpy.liaosc.scorder.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @author: guopy
 * @Date: 2020/8/19 20:45
 * @version: v1.0.0
 */
@Slf4j
public class OrderRq2OrderDtoConverter {

    public static OrderDto convert(OrderRq orderRq){
        Gson gson = new Gson();
        OrderDto orderDTO = new OrderDto();
        orderDTO.setBuyerName(orderRq.getName());
        orderDTO.setBuyerPhone(orderRq.getPhone());
        orderDTO.setBuyerAddress(orderRq.getAddress());
        orderDTO.setBuyerOpenid(orderRq.getOpenid());

        List<OrderDetail> orderDetailList = new ArrayList<>();
        try {
            orderDetailList = gson.fromJson(orderRq.getItems(),
                    new TypeToken<List<OrderDetail>>() {
                    }.getType());
        } catch (Exception e) {
            log.error("[json转换]错误, string=[{}]", orderRq.getItems());
            throw new BusinessException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetailList);

        return orderDTO;
    }

}