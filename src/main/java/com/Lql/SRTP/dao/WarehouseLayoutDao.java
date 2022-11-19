package com.Lql.SRTP.dao;

import com.Lql.SRTP.entity.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WarehouseLayoutDao {
    //根据货物id找到订单中订购的货物
    List<Orderitem> getorderitemByPid(Integer pid);

    //根据货物id找到货物信息
    Product getproductByPid(Integer pid);

    //获得所有货物列表
    List<Product> getAllproduct();

    //根据货架id返回货架类
    Shelves getshelvesBysid(Integer sid);

    //获得所有货架列表
    List<Shelves> getAllshelves();

    //获取月末x的库存
    Orderitem gettimerest(String time, Integer pid);

    //修改产品的iton值
    Integer changeproduct(Double iton, Double itom, Integer pid);

    //获取共同出现的pid
    List<Orderitem> gettogetheritem(Integer one, Integer two);

    //修改货架关系表
    Integer updatashelvesdis(Integer pid1, Integer pid2, Double num);

    //获取货架关系表
    ShelvesDis getshelvesdis(Integer sid1, Integer sid2);

    //获取仓库基本信息
    Housebase gethousebase(Integer id);
    //修改仓库基本信息


}
