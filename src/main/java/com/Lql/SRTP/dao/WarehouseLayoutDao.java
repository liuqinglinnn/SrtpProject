package com.Lql.SRTP.dao;


import com.Lql.SRTP.entity.productputshelvesentity;
import com.Lql.SRTP.entity.srtporderitem;
import com.Lql.SRTP.entity.srtpproduct;
import com.Lql.SRTP.entity.srtpshelves;

import java.util.List;

public interface WarehouseLayoutDao {
    //根据货物id找到订单中订购的货物
    List<srtporderitem> getorderitemByPid(Integer pid);

    //根据货物id找到货物信息
    srtpproduct getproductByPid(Integer pid);

    //获得所有货物列表
    List<srtpproduct> getAllproduct();

    //根据货架id返回货架类
    srtpshelves getshelveBysid(Integer sid);

    //获得所有货架列表
    List<srtpshelves> getAllshelves();

    //获得货架对应的货物和货架的位置
    List<productputshelvesentity> getPSrealtionship();
}
