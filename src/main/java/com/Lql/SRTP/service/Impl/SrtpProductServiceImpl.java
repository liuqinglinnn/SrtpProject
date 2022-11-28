package com.Lql.SRTP.service.Impl;

import com.Lql.SRTP.dao.SrtpProductMapper;
import com.Lql.SRTP.entity.SrtpProduct;
import com.Lql.SRTP.service.ISrtpProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("SrtpProductService")
public class SrtpProductServiceImpl implements ISrtpProductService {

    @Autowired
    private SrtpProductMapper productMapper;

    @Override
    public SrtpProduct getProductById(Integer productId) {
        List<SrtpProduct> products = productMapper.selectByAll(SrtpProduct.builder().sid(productId).build());
        if (products == null || products.size() <= 0) {
            throw new RuntimeException("该商品不存在");
        }
        return products.get(0);
    }

    @Override
    public List<SrtpProduct> listProductsByName(String productName) {
        return productMapper.selectByProductName(productName);
    }


}
