package com.Lql.SRTP.controller;

import com.Lql.SRTP.entity.SrtpProduct;
import com.Lql.SRTP.entity.vo.SrtpOrderDetailVo;
import com.Lql.SRTP.service.ISrtpProductService;
import com.Lql.SRTP.util.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@Api(tags = "Product")
@RequestMapping("/srtp/product")
public class SrtpProductController {

    @Autowired
    private ISrtpProductService productService;

    @GetMapping("/getProductById")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "productId", value = "商品ID"),
    })
    @ApiOperation("根据ID获取商品信息")
    public JsonResult<Object> getProductById(@RequestParam Integer productId) {
        try {
            SrtpProduct product = productService.getProductById(productId);
            return JsonResult.success(product);
        } catch (Exception e) {
            log.error("SrtpProductController.getProductById发生异常: ", e);
            return JsonResult.failure(e.getMessage());
        }
    }

    @GetMapping("/getProductByName")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "商品名称"),
    })
    @ApiOperation("根据名称模糊搜索商品")
    public JsonResult<Object> getProductByName(@RequestParam String name) {
        try {
            List<SrtpProduct> products = productService.listProductsByName(name);
            return JsonResult.success(products);
        } catch (Exception e) {
            log.error("SrtpProductController.getProductByName发生异常: ", e);
            return JsonResult.failure(e.getMessage());
        }
    }
}
