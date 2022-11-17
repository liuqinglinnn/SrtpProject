package com.Lql.SRTP.dao;

import com.Lql.SRTP.entity.Product;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ScannerDao {
    //根据pid获取商品信息
    Product getproductByPid(Integer pid);
}
