package com.gpy.liaosc.scproduct.dao;

import com.gpy.liaosc.scproduct.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Description:
 * @author: guopy
 * @Date: 2020/7/30 22:21
 * @version: v1.0.0
 */
public interface ProductInfoDao extends JpaRepository<ProductInfo, String> {

    List<ProductInfo> findByProductStatus(Integer status);

    List<ProductInfo> findByProductIdIn(List<String> productIdList);

}
