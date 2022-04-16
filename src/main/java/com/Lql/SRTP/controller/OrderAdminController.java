package com.Lql.SRTP.controller;


import com.Lql.SRTP.entity.srtporderitem;
import com.Lql.SRTP.service.IOrderAdminService;
import com.Lql.SRTP.util.Jsonresult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("OrderAdmin")
public class OrderAdminController extends BaseController {
    @Autowired
    private IOrderAdminService IOrderAdminService;
    @RequestMapping("CreateOid")
    //进入订单页面生成oid
    public Jsonresult<Integer> Createoid() {
        Integer data = IOrderAdminService.Createoid();
        return new Jsonresult<Integer>(OK, data);
    }

    @RequestMapping("Addorderitem")
    //订单添加商品
    public void Addorderitem(Integer pid, String pname, Integer pnum, Integer oid) {
        IOrderAdminService.Addorderitem(pid, pname, pnum, oid);
    }

    @RequestMapping("Showorderitem")
    //根据订单id获取订单中商品数据
    public Jsonresult<List<srtporderitem>> showorderitembyoid(Integer oid) {
        List<srtporderitem> data = IOrderAdminService.Showorderitembyoid(oid);
        return new Jsonresult<List<srtporderitem>>(OK, data);
    }
    @RequestMapping("Addorder")
    //确认生成订单
    public void Addorder(Integer oid,String ordersort,String ordernote){
        IOrderAdminService.Addorder(oid,ordersort,ordernote);
    }


}
