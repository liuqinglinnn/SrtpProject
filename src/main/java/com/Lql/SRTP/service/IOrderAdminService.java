package com.Lql.SRTP.service;

import com.Lql.SRTP.entity.Orderitem;

import java.util.List;

public interface IOrderAdminService {
    //进入订单页面生成oid
    Integer Createoid();
    //订单添加商品
    void Addorderitem(Integer oid,Integer pid,String pname,Integer pnum,String openid);
    //根据订单id获取订单中商品数据
    List<Orderitem> Readorderitembyoid(Integer oid);
    //确认生成订单
    void Addorder(Integer oid,String order_reviewer,String ordersort,String ordernote,Long order_price);
}
