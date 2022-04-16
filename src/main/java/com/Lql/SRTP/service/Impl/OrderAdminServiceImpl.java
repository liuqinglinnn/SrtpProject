package com.Lql.SRTP.service.Impl;

import com.Lql.SRTP.dao.OrderAdiminDao;
import com.Lql.SRTP.entity.srtporder;
import com.Lql.SRTP.entity.srtporderitem;
import com.Lql.SRTP.service.IOrderAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class OrderAdminServiceImpl implements IOrderAdminService {
    @Autowired
    private OrderAdiminDao OrderAdiminDao;
@Override
    //进入订单页面生成oid
public Integer Createoid(){
    Date date = new Date();//获得系统时间.
    SimpleDateFormat sdf =   new SimpleDateFormat( " yyyy-MM-dd HH:mm:ss " );
    String dates = sdf.format(date);
   int oidnew=OrderAdiminDao.createoid(dates);
    return oidnew;
}
    @Override
    //订单添加商品
    public void Addorderitem(Integer pid, String pname, Integer pnum, Integer oid) {
        srtporderitem item = new srtporderitem();
        item.setPid(pid);
        item.setOid(oid);
        item.setPnum(pnum);
        item.setPname(pname);
        OrderAdiminDao.addorderitem(item);
    }

    @Override
    //根据订单id获取订单中商品数据
    public List<srtporderitem> Showorderitembyoid(Integer oid) {
        List<srtporderitem> list = OrderAdiminDao.showorderitembyoid(oid);
        return list;
    }

    @Override
    //确认生成订单
    public void Addorder(Integer oid, String ordersort, String ordernote){
        Date date = new Date();//获得系统时间.
        SimpleDateFormat sdf =   new SimpleDateFormat( " yyyy-MM-dd HH:mm:ss " );
        String dates = sdf.format(date);
        srtporder order=new srtporder();
        order.setOid(oid);
        order.setOrdertime(dates);
        order.setOrderreviewer("张三");
        order.setOrdersort(ordersort);
        order.setOrdernote(ordernote);
        OrderAdiminDao.addorder(order);
    }


}
