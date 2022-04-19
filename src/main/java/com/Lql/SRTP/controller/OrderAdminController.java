package com.Lql.SRTP.controller;


import com.Lql.SRTP.entity.Orderitem;
import com.Lql.SRTP.service.IOrderAdminService;
import com.Lql.SRTP.util.Jsonresult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("OrderAdmin")
public class OrderAdminController extends BaseController {
    @Autowired
    private IOrderAdminService IOrderAdminService;
    @GetMapping("CreateOid")
    //进入订单页面生成oid
    public Jsonresult<Integer> Createoid() {
        Integer data = IOrderAdminService.Createoid();
        return new Jsonresult<Integer>(OK, data);
    }

    @PostMapping("Addorderitem")
    //订单添加商品
    public void Addorderitem(Integer oid,Integer pid,String pname,Integer pnum,String openid) {
        IOrderAdminService.Addorderitem(oid,pid,pname,pnum,openid);
    }
    @GetMapping("Readorderitem")
    //根据订单id获取订单中商品数据
    public Jsonresult<List<Orderitem>> Readorderitembyoid(Integer oid) {
        List<Orderitem> data = IOrderAdminService.Readorderitembyoid(oid);
        return new Jsonresult<>(OK, data);
    }
    @PostMapping("Addorder")
    //确认生成订单
    public void Addorder(Integer oid,String order_reviewer,String ordersort,String ordernote,Long order_price){
        IOrderAdminService.Addorder(oid,order_reviewer,ordersort,ordernote,order_price);
    }


}
