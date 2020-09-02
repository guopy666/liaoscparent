package com.gpy.liaosc.scorder.service.impl;

import com.gpy.liaosc.scorder.client.ProductClient;
import com.gpy.liaosc.scorder.constant.OrderStatusEnum;
import com.gpy.liaosc.scorder.constant.PayStatusEnum;
import com.gpy.liaosc.scorder.dao.OrderDetailDao;
import com.gpy.liaosc.scorder.dao.OrderMasterDao;
import com.gpy.liaosc.scorder.dto.CartDto;
import com.gpy.liaosc.scorder.dto.OrderDto;
import com.gpy.liaosc.scorder.entity.OrderDetail;
import com.gpy.liaosc.scorder.entity.OrderMaster;
import com.gpy.liaosc.scorder.entity.ProductInfo;
import com.gpy.liaosc.scorder.service.OrderService;
import com.gpy.liaosc.scorder.utils.IdWorker;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

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

    @Autowired
    private ProductClient productClient;

    @Override
    @Transactional
    public OrderDto createOrder(OrderDto orderDto) {

        String orderId = IdWorker.getId();

        //查询商品信息
        List<String> productIdList = orderDto.getOrderDetailList().stream().map(OrderDetail::getProductId)
                .collect(Collectors.toList());
        List<ProductInfo> productInfos = productClient.listForOrder(productIdList);

        //计算总价
        BigDecimal totalAmout = new BigDecimal(BigInteger.ZERO);
        for (OrderDetail orderDetail : orderDto.getOrderDetailList()) {
            for (ProductInfo productInfo : productInfos) {
                if (productInfo.getProductId().equals(orderDetail.getProductId())){
                    totalAmout = productInfo.getProductPrice().multiply(new BigDecimal(orderDetail.getProductQuantity()))
                            .add(totalAmout);
                    BeanUtils.copyProperties(productInfo, orderDetail);
                    orderDetail.setOrderId(orderId);
                    orderDetail.setDetailId(IdWorker.getId());

                    //订单详情入库
                    orderDetailDao.save(orderDetail);

                }

            }
        }

        //扣库存
        List<CartDto> cartDtoList = orderDto.getOrderDetailList().stream()
                .map(item -> new CartDto(item.getProductId(), item.getProductQuantity()))
                .collect(Collectors.toList());
        productClient.decreaseStock(cartDtoList);

        //订单入库
        OrderMaster orderMaster = new OrderMaster();
        orderDto.setOrderId(IdWorker.getId());
        BeanUtils.copyProperties(orderDto, orderMaster);
        orderMaster.setOrderAmount(totalAmout);
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getValue());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getValue());
        orderMasterDao.save(orderMaster);
        return orderDto;

    }
}