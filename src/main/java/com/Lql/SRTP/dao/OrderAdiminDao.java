package com.Lql.SRTP.dao;

import com.Lql.SRTP.entity.Order;
import com.Lql.SRTP.entity.Orderitem;
import com.Lql.SRTP.entity.Product;

import java.util.List;

public interface OrderAdiminDao {
    //进入订单页面生成oid
    Integer createoid();
    //订单添加商品
    Integer addorderitem(Orderitem item);
    //订单修改商品
    Integer updateorderitem(Orderitem item);
    //订单删除商品
    Integer deleteorderitem(Orderitem item);
    //根据订单id获取订单中商品数据
    List<Orderitem> readorderitembyoid(Integer oid);
    //确认生成订单
    Integer addorder(Order order);
    //根据pid获取商品信息
    Product getproductByPid(Integer pid);

}
