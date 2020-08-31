package com.gpy.liaosc.scproduct.service.impl;

import com.gpy.liaosc.scproduct.constant.ProductStatus;
import com.gpy.liaosc.scproduct.dao.ProductInfoDao;
import com.gpy.liaosc.scproduct.entity.ProductInfo;
import com.gpy.liaosc.scproduct.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @author: guopy
 * @Date: 2020/8/1 17:54
 * @version: v1.0.0
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductInfoDao productInfoDao;

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoDao.findByProductStatus(ProductStatus.UP.getValue());
    }
}