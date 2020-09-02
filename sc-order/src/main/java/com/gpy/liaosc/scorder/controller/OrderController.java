package com.gpy.liaosc.scorder.controller;

import com.gpy.liaosc.scorder.client.ProductClient;
import com.gpy.liaosc.scorder.constant.ResultEnum;
import com.gpy.liaosc.scorder.converter.OrderRq2OrderDtoConverter;
import com.gpy.liaosc.scorder.dto.OrderDto;
import com.gpy.liaosc.scorder.dto.OrderRq;
import com.gpy.liaosc.scorder.entity.ProductInfo;
import com.gpy.liaosc.scorder.exception.BusinessException;
import com.gpy.liaosc.scorder.service.OrderService;
import com.gpy.liaosc.scorder.utils.ResultVOUtils;
import com.gpy.liaosc.scorder.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @author: guopy
 * @Date: 2020/8/1 22:16
 * @version: v1.0.0
 */
@RestController
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductClient productClient;

    /**
     * @Description: 1 参数校验
     * 2 查询商品信息（调用商品服务）
     * 3 计算总价    4 扣库存（调用商品服务）
     * 5 订单入库
     * @Date: 2020/8/1 22:17
     * @param
     * @return: void
     * @author: guopy
     **/
    @PostMapping("/createorder")
    public ResultVO createOrder(@Valid OrderRq orderRq, BindingResult bindingResult){

         if (bindingResult.hasErrors()){
             log.error("create order error");
             throw new BusinessException(ResultEnum.PARAM_ERROR.getValue(), bindingResult.getFieldError().getDefaultMessage());
         }

        OrderDto orderDto = OrderRq2OrderDtoConverter.convert(orderRq);
        if (CollectionUtils.isEmpty(orderDto.getOrderDetailList())){
            log.error("[创建订单] 购物车为空");
            throw new BusinessException(ResultEnum.CART_EMPTY);
        }

        OrderDto result = orderService.createOrder(orderDto);

        Map<String, String> map = new HashMap<>();

        map.put("orderId", result.getOrderId());
        return ResultVOUtils.success(map);
    }

    @GetMapping("/getProductList")
    public List<ProductInfo> getProductList(){
        List<ProductInfo> productInfos = productClient.listForOrder(Arrays.asList("164103465734242707"));
        System.out.println(productInfos.get(0));
        return productInfos;
    }


}