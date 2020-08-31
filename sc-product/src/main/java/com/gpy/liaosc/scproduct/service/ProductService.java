package com.gpy.liaosc.scproduct.service;

import com.gpy.liaosc.scproduct.entity.ProductInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @author: guopy
 * @Date: 2020/8/1 17:53
 * @version: v1.0.0
 */
public interface ProductService {

    /**
     * @Description: 查询所有上架的商品
     * @Date: 2020/8/1 17:54
     * @param
     * @return: java.util.List<com.gpy.liaosc.scproduct.entity.ProductInfo>
     * @author: guopy
     **/
    List<ProductInfo> findUpAll();
}