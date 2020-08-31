package com.gpy.liaosc.scorder.utils;

import com.gpy.liaosc.scorder.vo.ResultVO;

/**
 * @Description:
 * @author: guopy
 * @Date: 2020/8/1 18:57
 * @version: v1.0.0
 */
public class ResultVOUtils {

    public static ResultVO success(Object data){
        ResultVO resultVO = new ResultVO();
        resultVO.setMsg("成功");
        resultVO.setData(data);
        resultVO.setCode(0);
        return resultVO;
    }
}