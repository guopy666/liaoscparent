package com.gpy.liaosc.scproduct.dao;

import com.gpy.liaosc.scproduct.BaseTest;
import com.gpy.liaosc.scproduct.entity.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Description:
 * @author: guopy
 * @Date: 2020/7/30 22:22
 * @version: v1.0.0
 */
public class ProductInfoDaoTest extends BaseTest {

    @Autowired
    private ProductInfoDao productInfoDao;

    @Test
    public void findByProductStatus(){
        List<ProductInfo> infos = productInfoDao.findByProductStatus(0);
        Assert.assertTrue(infos.size()>0);
    }
}