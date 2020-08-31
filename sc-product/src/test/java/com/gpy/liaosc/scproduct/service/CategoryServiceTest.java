package com.gpy.liaosc.scproduct.service;

import com.gpy.liaosc.scproduct.BaseTest;
import com.gpy.liaosc.scproduct.entity.ProductCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @author: guopy
 * @Date: 2020/8/1 18:05
 * @version: v1.0.0
 */
public class CategoryServiceTest extends BaseTest {

    @Autowired
    private CategoryService categoryService;

    @Test
    public void findByCategoryTypeIn() {
        List<ProductCategory> categories = categoryService.findByCategoryTypeIn(Arrays.asList(11, 22));
        System.out.println(categories);
    }
}