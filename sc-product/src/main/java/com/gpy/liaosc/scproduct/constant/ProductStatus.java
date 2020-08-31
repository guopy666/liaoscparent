package com.gpy.liaosc.scproduct.constant;

/**
 * @Description: 商品上下架状态
 * @author: guopy
 * @Date: 2020/8/1 17:56
 * @version: v1.0.0
 */
public enum ProductStatus {

    UP(0, "在架"),
    DOWN(1, "下架")
    ;

    private Integer value;
    private String text;

    private ProductStatus(Integer value, String text) {
        this.value = value;
        this.text = text;
    }

    public Integer getValue () {
        return value;
    }

    public String getText () {
        return text;
    }

    public static String getText(Integer value) {
        for (ProductStatus status : ProductStatus.values()) {
            if (status.value.equals(value)) {
                return status.text;
            }
        }

        throw new IllegalArgumentException("illegal value: " + value);
    }
}