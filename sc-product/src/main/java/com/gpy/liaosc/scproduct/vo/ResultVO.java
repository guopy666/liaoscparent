package com.gpy.liaosc.scproduct.vo;

import lombok.Data;

/**
 * @Description: http请求返回的最外层对象
 * @author: guopy
 * @Date: 2020/8/1 18:07
 * @version: v1.0.0
 */
@Data
public class ResultVO<T> {

    private Integer code;
    private String msg;
    private T data;

}