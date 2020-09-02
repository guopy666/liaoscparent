package com.gpy.liaosc.scproduct.service.impl;

import com.gpy.liaosc.scproduct.constant.ProductStatus;
import com.gpy.liaosc.scproduct.constant.ResultEnum;
import com.gpy.liaosc.scproduct.dao.ProductInfoDao;
import com.gpy.liaosc.scproduct.dto.CartDto;
import com.gpy.liaosc.scproduct.entity.ProductInfo;
import com.gpy.liaosc.scproduct.exception.BusinessException;
import com.gpy.liaosc.scproduct.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * @Description:
 * @author: guopy
 * @Date: 2020/8/1 17:54
 * @version: v1.0.0
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductInfoDao productInfoDao;

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoDao.findByProductStatus(ProductStatus.UP.getValue());
    }

    @Override
    public List<ProductInfo> findListByIds(List<String> productIds) {
        return productInfoDao.findByProductIdIn(productIds);
    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDto> cartDtoList) {
        for (CartDto cartDto : cartDtoList) {
            Optional<ProductInfo> one = productInfoDao.findById(cartDto.getProductId());
            if (one == null){
                throw new BusinessException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            ProductInfo productInfo = one.get();
            int i = productInfo.getProductStock() - cartDto.getProductQuantity();
            if (i < 0){
                throw new BusinessException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            productInfo.setProductStock(i);
            productInfoDao.save(productInfo);
        }
    }
}