package com.gpy.liaosc.scproduct.dao;

import com.gpy.liaosc.scproduct.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Description:
 * @author: guopy
 * @Date: 2020/7/30 22:36
 * @version: v1.0.0
 */
public interface ProductCategoryDao extends JpaRepository<ProductCategory, Integer> {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

}
