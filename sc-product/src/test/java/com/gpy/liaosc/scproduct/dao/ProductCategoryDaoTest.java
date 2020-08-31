package com.gpy.liaosc.scproduct.dao;

import com.gpy.liaosc.scproduct.BaseTest;
import com.gpy.liaosc.scproduct.entity.ProductCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @author: guopy
 * @Date: 2020/8/1 17:48
 * @version: v1.0.0
 */
public class ProductCategoryDaoTest extends BaseTest {

    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Test
    public void findByCategoryTypeIn() {
        List<ProductCategory> categoryList = productCategoryDao.findByCategoryTypeIn(Arrays.asList(11, 12));
        System.out.println(categoryList);
    }
}