package com.Lql.SRTP.service;

import com.Lql.SRTP.entity.srtporder;
import com.Lql.SRTP.entity.srtporderitem;

import java.util.List;

public interface IOrderAdminService {
    //进入订单页面生成oid
    Integer Createoid();
    //订单添加商品
    void Addorderitem(Integer pid, String pname, Integer pnum, Integer oid);
    //根据订单id获取订单中商品数据
    List<srtporderitem> Showorderitembyoid(Integer oid);
    //确认生成订单
    void Addorder(Integer oid,String ordersort,String ordernote);
}
