package com.Lql.SRTP.dao;

import com.Lql.SRTP.entity.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WarehouseLayoutDao {
    //根据货物id找到订单中订购的货物
    List<SrtpOrderItem> getorderitemByPid(Integer pid);

    //根据货物id找到货物信息
    SrtpProduct getproductByPid(Integer pid);

    //获得所有货物列表
    List<SrtpProduct> getAllproduct();

    //根据货架id返回货架类
    SrtpShelves getshelvesBysid(Integer sid);

    //获得所有货架列表
    List<SrtpShelves> getAllshelves();

    //获取月末x的库存
    SrtpOrderItem gettimerest(String time, Integer pid);

    //修改产品的iton值
    Integer changeproduct(Double iton, Double itom, Integer pid);

    //获取共同出现的pid
    List<SrtpOrderItem> gettogetheritem(Integer one, Integer two);

    //修改货架关系表
    Integer updatashelvesdis(Integer pid1, Integer pid2, Double num);

    //获取货架关系表
    SrtpShelvesDis getshelvesdis(Integer sid1, Integer sid2);

    //获取仓库基本信息
    SrtpHouseBase gethousebase(Integer id);
    //修改仓库基本信息


}
