package com.Lql.SRTP.dao;

import com.Lql.SRTP.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
    Orderitem gettimerest(@Param("time") String time, @Param("pid") Integer pid);

    //修改产品的iton值
    Integer changeproduct(@Param("iton") Double iton, @Param("itom") Double itom, @Param("pid") Integer pid);

    //获取共同出现的pid
    List<Orderitem> gettogetheritem(@Param("one") Integer one, @Param("two") Integer two);

    //修改货架关系表
    Integer updatashelvesdis(@Param("pid1") Integer pid1, @Param("pid2") Integer pid2, @Param("num") Double num);

    //获取货架关系表
    ShelvesDis getshelvesdis(@Param("sid1") Integer sid1, @Param("sid2") Integer sid2);

    //获取仓库基本信息
    Housebase gethousebase(Integer id);
    //修改货架评分
    void changeshelvessv(Integer sid,Double sv);
    //修改仓库基本信息


}
