package com.gpy.liaosc.scorder.dao;

import com.gpy.liaosc.scorder.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Description:
 * @author: guopy
 * @Date: 2020/8/1 19:23
 * @version: v1.0.0
 */
public interface OrderDetailDao extends JpaRepository<OrderDetail, String > {


}
