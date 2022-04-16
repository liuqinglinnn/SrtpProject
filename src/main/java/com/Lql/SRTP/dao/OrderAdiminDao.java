package com.Lql.SRTP.dao;

import com.Lql.SRTP.entity.srtporder;
import com.Lql.SRTP.entity.srtporderitem;

import java.util.List;

public interface OrderAdiminDao {
    //进入订单页面生成oid
    Integer createoid(String ordertime);
    //订单添加商品
    Integer addorderitem(srtporderitem item);

    //订单修改商品
    //订单删除商品
    //根据订单id获取订单中商品数据
    List<srtporderitem> showorderitembyoid(Integer oid);
    //确认生成订单
    Integer addorder(srtporder order);
}
