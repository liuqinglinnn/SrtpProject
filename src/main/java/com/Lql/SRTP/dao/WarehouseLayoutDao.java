package com.Lql.SRTP.dao;


import com.Lql.SRTP.entity.Optimize_product;
import com.Lql.SRTP.entity.Orderitem;
import com.Lql.SRTP.entity.Product;
import com.Lql.SRTP.entity.Shelves;

import java.util.List;

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

    //获得货架对应的货物和货架的位置
    List<Optimize_product> getPSrealtionship();
}
