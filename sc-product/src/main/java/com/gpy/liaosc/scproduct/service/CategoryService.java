package com.gpy.liaosc.scproduct.service;

import com.gpy.liaosc.scproduct.entity.ProductCategory;

import java.util.List;

/**
 * @Description:
 * @author: guopy
 * @Date: 2020/8/1 18:02
 * @version: v1.0.0
 */
public interface CategoryService {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}