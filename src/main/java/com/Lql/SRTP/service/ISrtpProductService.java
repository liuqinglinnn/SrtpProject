package com.Lql.SRTP.service;

import com.Lql.SRTP.entity.SrtpProduct;

import java.util.List;

public interface ISrtpProductService {

    /**
     * 根据商品id获取商品信息
     * @param productId
     * @return
     */
    SrtpProduct getProductById(Integer productId);

    /**
     * 根据商品名称模糊搜索商品
     * @param productName
     * @return
     */
    List<SrtpProduct> listProductsByName(String productName);
}
