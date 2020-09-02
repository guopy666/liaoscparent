package com.gpy.liaosc.scorder.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description:
 * @author: guopy
 * @Date: 2020/8/1 19:20
 * @version: v1.0.0
 */
@Data
@Entity
@Accessors(chain = true)
public class OrderMaster {
    /** 订单id. */
    @Id
    private String orderId;

    /** 买家名字. */
    private String buyerName;

    /** 买家手机号. */
    private String buyerPhone;

    /** 买家地址. */
    private String buyerAddress;

    /** 买家微信Openid. */
    private String buyerOpenid;

    /** 订单总金额. */
    private BigDecimal orderAmount;

    /** 订单状态, 默认为0新下单. */
    private Integer orderStatus;

    /** 支付状态, 默认为0未支付. */
    private Integer payStatus;

    /** 创建时间. */
    @CreationTimestamp
    @Column(insertable = false, updatable = false)
    private Date createTime;

    /** 更新时间. */
    @UpdateTimestamp
    @Column(insertable = false)
    private Date updateTime;
}