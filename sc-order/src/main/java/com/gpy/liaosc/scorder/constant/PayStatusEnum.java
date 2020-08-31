package com.gpy.liaosc.scorder.constant;

/**
 * @Description:
 * @author: guopy
 * @Date: 2020/8/1 19:44
 * @version: v1.0.0
 */
public enum PayStatusEnum {

    WAIT(0, "等待支付"),
    SUCCESS(1, "支付成功"),
    ;
    private Integer value;
    private String text;

    private PayStatusEnum(Integer value, String text) {
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
        for (PayStatusEnum status : PayStatusEnum.values()) {
            if (status.value.equals(value)) {
                return status.text;
            }
        }

        throw new IllegalArgumentException("illegal value: " + value);
    }
}
