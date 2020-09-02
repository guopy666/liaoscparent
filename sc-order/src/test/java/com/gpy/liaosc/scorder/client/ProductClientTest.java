package com.gpy.liaosc.scorder.client;

import com.gpy.liaosc.scorder.BaseTest;
import com.gpy.liaosc.scorder.dto.CartDto;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

/**
 * @ClassName ProductClientTest
 * @Description
 * @Author guopy
 * @Date 2020/9/2 22:41
 */
public class ProductClientTest extends BaseTest {

    @Autowired
    private ProductClient productClient;


    @Test
    public void decreaseStockTest(){
        CartDto cartDto = new CartDto();
        cartDto.setProductId("164103465734242707");
        cartDto.setProductQuantity(2);
        productClient.decreaseStock(Arrays.asList(cartDto));
    }

}
