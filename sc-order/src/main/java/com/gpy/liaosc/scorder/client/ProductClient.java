package com.gpy.liaosc.scorder.client;

import com.gpy.liaosc.scorder.dto.CartDto;
import com.gpy.liaosc.scorder.entity.ProductInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @ClassName ProductClient
 * @Description
 * @Author guopy
 * @Date 2020/9/1 23:12
 */
@FeignClient(name = "sc-product")
public interface ProductClient {

    @PostMapping("/product/listForOrder")
    List<ProductInfo> listForOrder(@RequestBody List<String> productIdList);

    @PostMapping("/product/decreaseStock")
    void decreaseStock(@RequestBody List<CartDto> cartDtoList);

}
