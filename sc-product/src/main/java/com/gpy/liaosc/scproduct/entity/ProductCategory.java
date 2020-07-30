package com.gpy.liaosc.scproduct.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * @Description:
 * @author: guopy
 * @Date: 2020/7/30 22:35
 * @version: v1.0.0
 */
@Entity
@Data
public class ProductCategory {

    @Id
    @GeneratedValue
    private Integer categoryId;

    /** 类目名字. */
    private String categoryName;

    /** 类目编号. */
    private Integer categoryType;

    private Date createTime;

    private Date updateTime;
}