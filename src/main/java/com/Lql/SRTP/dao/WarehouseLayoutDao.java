package com.Lql.SRTP.dao;

import com.Lql.SRTP.entity.Orderitem;
import com.Lql.SRTP.entity.Product;
import com.Lql.SRTP.entity.Shelves;
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
    //计算x的周转量，周转率，
    //x的出入库距离之和
    //分出商品的abc种类
    //计算x的相关性之和，x和y的共线频次以及xy的距离
    //计算score x=num1+num2；
    //存入数据表，货架的value值，如果货架没货物就value=-100；货架评分为负，障碍物
    //计算scoresum,存入数据库，作为返回结果

}
