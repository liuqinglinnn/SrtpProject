package com.Lql.SRTP.dao;

import com.Lql.SRTP.entity.Product;

public interface ScannerDao {
    //根据pid获取商品信息
    Product getproductByPid(Integer pid);
}
