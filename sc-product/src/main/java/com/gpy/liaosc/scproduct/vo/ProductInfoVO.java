package com.gpy.liaosc.scproduct.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Description:
 * @author: guopy
 * @Date: 2020/8/1 18:10
 * @version: v1.0.0
 */
@Data
public class ProductInfoVO {

    @JsonProperty("id")
    private String productId;
    @JsonProperty("name")
    private String productName;
    @JsonProperty("price")
    private BigDecimal productPrice;
    @JsonProperty("description")
    private String productDesc;
    @JsonProperty("icon")
    private String productIcon;

}