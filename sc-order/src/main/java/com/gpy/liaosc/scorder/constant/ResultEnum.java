package com.gpy.liaosc.scorder.constant;

/**
 * @Description:
 * @author: guopy
 * @Date: 2020/8/1 19:41
 * @version: v1.0.0
 */
public enum ResultEnum {

    PARAM_ERROR(1, "参数错误"),
    CART_EMPTY(2, "购物车为空"),
    ORDER_NOT_EXIST(3, "订单不存在"),
    ORDER_STATUS_ERROR(4, "订单状态错误"),
    ORDER_DETAIL_NOT_EXIST(5, "订单详情不存在"),

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
