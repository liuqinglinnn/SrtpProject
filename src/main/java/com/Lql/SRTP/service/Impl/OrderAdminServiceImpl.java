package com.Lql.SRTP.service.Impl;

import com.Lql.SRTP.dao.OrderAdiminDao;
import com.Lql.SRTP.entity.Order;
import com.Lql.SRTP.entity.Orderitem;
import com.Lql.SRTP.entity.Product;
import com.Lql.SRTP.service.IOrderAdminService;
import com.Lql.SRTP.service.ex.PidNotFoundException;
import com.Lql.SRTP.service.ex.ProductNumException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class OrderAdminServiceImpl implements IOrderAdminService {
    @Autowired
    private OrderAdiminDao OrderAdiminDao;

    @Override
    //进入订单页面生成oid
    public Integer Createoid() {
        int oidnew = OrderAdiminDao.createoid();
        return oidnew;
    }

    @Override
    //订单添加商品
    public void Addorderitem(Integer oid, Integer pid, String pname, Integer pnum, String openid) {
        Product product = OrderAdiminDao.getproductByPid(pid);
        //订单商品重复添加
        //订单商品缺货或订购数太多
        if (pnum > product.getNum()) {
            throw new ProductNumException("订购数大于库存，请重新输入订购数");
        }
        //库存中无商品信息或扫码不正确
        if (product.getId() == null) {
            throw new PidNotFoundException("无商品信息");
        }
        Orderitem item = new Orderitem();
        Long pprice = product.getPrice();
        Long ptotalprice = pprice * pnum;
        Date date = new Date();//获得系统时间.
        SimpleDateFormat sdf = new SimpleDateFormat(" yyyy-MM-dd HH:mm:ss ");
        String dates = sdf.format(date);
        item.setOid(oid);
        item.setPid(pid);
        item.setPname(pname);
        item.setPnum(pnum);
        item.setPprice(pprice);
        item.setPtotalprice(ptotalprice);
        item.setPcreatetime(dates);
        item.setPcreateruser(openid);
        item.setPimage(product.getImage());
        OrderAdiminDao.addorderitem(item);
    }

    @Override
    //根据订单id获取订单中商品数据
    public List<Orderitem> Readorderitembyoid(Integer oid) {
        List<Orderitem> list = OrderAdiminDao.readorderitembyoid(oid);
        return list;
    }

    @Override
    //确认生成订单
    public void Addorder(Integer oid, String order_reviewer, String ordersort, String ordernote, Long order_price) {
        Date date = new Date();//获得系统时间.
        SimpleDateFormat sdf = new SimpleDateFormat(" yyyy-MM-dd HH:mm:ss ");
        String dates = sdf.format(date);
        Order order = new Order();
        order.setOid(oid);
        order.setOrder_createtime(dates);
        order.setOrder_reviewer(order_reviewer);
        order.setOrder_sort(ordersort);
        order.setOrder_note(ordernote);
        order.setOrder_price(order_price);
        OrderAdiminDao.addorder(order);
    }

    @Override
    //根据pid获取商品信息
    public Product GetproductByPid(Integer pid) {
        Product product = OrderAdiminDao.getproductByPid(pid);
        return product;
    }
}
