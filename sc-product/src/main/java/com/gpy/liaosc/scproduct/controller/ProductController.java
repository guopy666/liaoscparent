package com.gpy.liaosc.scproduct.controller;

import com.google.common.collect.Lists;
import com.gpy.liaosc.scproduct.dto.CartDto;
import com.gpy.liaosc.scproduct.entity.ProductCategory;
import com.gpy.liaosc.scproduct.entity.ProductInfo;
import com.gpy.liaosc.scproduct.service.CategoryService;
import com.gpy.liaosc.scproduct.service.ProductService;
import com.gpy.liaosc.scproduct.utils.ResultVOUtils;
import com.gpy.liaosc.scproduct.vo.ProductInfoVO;
import com.gpy.liaosc.scproduct.vo.ProductVO;
import com.gpy.liaosc.scproduct.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description:
 * @author: guopy
 * @Date: 2020/7/30 22:09
 * @version: v1.0.0
 */
@RestController
@RequestMapping("/product")
public class ProductController  {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    /**
     * @Description: 1 查询所有在架的商品
     * 2 获取类目type列表
     * 3 查询类目
     * 4 构造数据
     * @Date: 2020/7/30 22:35
     * @param
     * @return: void
     * @author: guopy
     **/
    @GetMapping("/list")
    public ResultVO<List<ProductVO>> list(){
        List<ProductInfo> productInfos = productService.findUpAll();
        List<Integer> categoryTypeList = productInfos.stream().map(ProductInfo::getCategoryType).collect(Collectors.toList());
        List<ProductCategory> categoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        //构造数据
        List<ProductVO> productVOs = Lists.newArrayList();

        for (ProductCategory productCategory : categoryList) {
            ProductVO productVO = new ProductVO();
            BeanUtils.copyProperties(productCategory, productVO);

            List<ProductInfoVO> productInfoVOs = Lists.newArrayList();

            for (ProductInfo info : productInfos) {
                if (info.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO infoVO = new ProductInfoVO();
                    infoVO.setProductDesc(info.getProductDescription());
                    infoVO.setProductIcon(info.getProductIcon());
                    infoVO.setProductId(info.getProductId());
                    infoVO.setProductName(info.getProductName());
                    infoVO.setProductPrice(info.getProductPrice());
                    productInfoVOs.add(infoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOs);

            productVOs.add(productVO);
        }

        return ResultVOUtils.success(productVOs);
    }

    /**
     * @Description  获取商品列表，for order service
     * @Author guopy
     * @Date 2020/9/2 21:42
     * @param productIdList
     * @Return java.util.List<com.gpy.liaosc.scproduct.entity.ProductInfo>
     **/
    @PostMapping("/listForOrder")
    public List<ProductInfo> listForOrder(@RequestBody List<String> productIdList){

        return productService.findListByIds(productIdList);
    }

    @PostMapping("/decreaseStock")
    public void decreaseStock(@RequestBody List<CartDto> cartDtoList){
        productService.decreaseStock(cartDtoList);
    }

}