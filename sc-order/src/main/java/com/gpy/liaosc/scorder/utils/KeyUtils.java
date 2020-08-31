package com.gpy.liaosc.scorder.utils;

import org.apache.commons.lang.math.RandomUtils;

import java.util.Random;

/**
 * @Description: 生成唯一的主键  时间戳+随机数
 * @author: guopy
 * @Date: 2020/8/18 20:49
 * @version: v1.0.0
 */
public class KeyUtils {

    public static synchronized String genUniquekey(){
        int i = RandomUtils.nextInt(6) + 100000;
        return System.currentTimeMillis() + String.valueOf(i);
    }

}