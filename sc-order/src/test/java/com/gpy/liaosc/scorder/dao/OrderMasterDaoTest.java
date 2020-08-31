package com.gpy.liaosc.scorder.dao;

import com.gpy.liaosc.scorder.BaseTest;
import com.gpy.liaosc.scorder.constant.OrderStatusEnum;
import com.gpy.liaosc.scorder.constant.PayStatusEnum;
import com.gpy.liaosc.scorder.entity.OrderMaster;
import com.gpy.liaosc.scorder.utils.IdWorker;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @Description:
 * @author: guopy
 * @Date: 2020/8/1 19:25
 * @version: v1.0.0
 */
public class OrderMasterDaoTest extends BaseTest {

    @Autowired
    private OrderMasterDao orderMasterDao;

    @Test
    public void saveTest(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("123456");
        orderMaster.setBuyerName("Guopy");
        orderMaster.setBuyerPhone("18861312412");
        orderMaster.setBuyerAddress("慕课网总部");
        orderMaster.setBuyerOpenid("1101110");
        orderMaster.setOrderAmount(new BigDecimal(2.5));
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getValue());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getValue());

        OrderMaster result = orderMasterDao.save(orderMaster);
        Assert.assertTrue(result != null);

    }

}