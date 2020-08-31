package com.gpy.liaosc.scorder.constant;

/**
 * @Description:
 * @author: guopy
 * @Date: 2020/8/1 19:40
 * @version: v1.0.0
 */
public enum OrderStatusEnum {

    NEW(0, "新订单"),
    FINISHED(1, "完结"),
    CANCEL(2, "取消"),
    ;
    private Integer value;
    private String text;

    private OrderStatusEnum(Integer value, String text) {
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
        for (OrderStatusEnum status : OrderStatusEnum.values()) {
            if (status.value.equals(value)) {
                return status.text;
            }
        }

        throw new IllegalArgumentException("illegal value: " + value);
    }

}