package com.gpy.liaosc.scproduct.service.impl;

import com.gpy.liaosc.scproduct.dao.ProductCategoryDao;
import com.gpy.liaosc.scproduct.entity.ProductCategory;
import com.gpy.liaosc.scproduct.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @author: guopy
 * @Date: 2020/8/1 18:03
 * @version: v1.0.0
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return productCategoryDao.findByCategoryTypeIn(categoryTypeList);
    }
}