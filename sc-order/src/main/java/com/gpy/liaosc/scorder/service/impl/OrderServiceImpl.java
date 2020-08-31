package com.gpy.liaosc.scorder.service.impl;

import com.gpy.liaosc.scorder.constant.OrderStatusEnum;
import com.gpy.liaosc.scorder.constant.PayStatusEnum;
import com.gpy.liaosc.scorder.dao.OrderDetailDao;
import com.gpy.liaosc.scorder.dao.OrderMasterDao;
import com.gpy.liaosc.scorder.dto.OrderDto;
import com.gpy.liaosc.scorder.entity.OrderMaster;
import com.gpy.liaosc.scorder.service.OrderService;
import com.gpy.liaosc.scorder.utils.IdWorker;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @Description:
 * @author: guopy
 * @Date: 2020/8/1 22:25
 * @version: v1.0.0
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDetailDao orderDetailDao;

    @Autowired
    private OrderMasterDao orderMasterDao;

    @Override
    public OrderDto createOrder(OrderDto orderDto) {

        //订单入库
        OrderMaster orderMaster = new OrderMaster();
        orderDto.setOrderId(IdWorker.getId());
        BeanUtils.copyProperties(orderDto, orderMaster);
        orderMaster.setOrderAmount(new BigDecimal(60));
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getValue());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getValue());
        orderMasterDao.save(orderMaster);
        return orderDto;

    }
}