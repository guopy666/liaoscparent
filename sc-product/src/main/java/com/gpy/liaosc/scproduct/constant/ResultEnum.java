package com.gpy.liaosc.scproduct.constant;

/**
 * @Description:
 * @author: guopy
 * @Date: 2020/8/1 19:41
 * @version: v1.0.0
 */
public enum ResultEnum {

    PRODUCT_NOT_EXIST(1, "商品不存在"),
    PRODUCT_STOCK_ERROR(2, "库存有误"),
    ;

    private Integer value;
    private String text;

    private ResultEnum(Integer value, String text) {
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
        for (ResultEnum status : ResultEnum.values()) {
            if (status.value.equals(value)) {
                return status.text;
            }
        }

        throw new IllegalArgumentException("illegal value: " + value);
    }
}
