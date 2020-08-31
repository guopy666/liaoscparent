package com.gpy.liaosc.scorder.dao;

import com.gpy.liaosc.scorder.BaseTest;
import com.gpy.liaosc.scorder.entity.OrderDetail;
import com.gpy.liaosc.scorder.utils.IdWorker;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @Description:
 * @author: guopy
 * @Date: 2020/8/1 22:05
 * @version: v1.0.0
 */
public class OrderDetailDaoTest extends BaseTest {

    @Autowired
    private OrderDetailDao orderDetailDao;

    @Test
    public void testSave(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("222222");
        orderDetail.setOrderId("123456");
        orderDetail.setProductIcon("http://xxx.com");
        orderDetail.setProductId("157875196366160022");
        orderDetail.setProductName("皮蛋粥");
        orderDetail.setProductPrice(new BigDecimal(0.01));
        orderDetail.setProductQuantity(2);

        OrderDetail result = orderDetailDao.save(orderDetail);
        Assert.assertTrue(result != null);
    }

}