package com.Lql.SRTP.service;

import com.Lql.SRTP.entity.SrtpOrder;
import com.Lql.SRTP.entity.vo.SrtpOrderDetailVo;
import com.Lql.SRTP.entity.vo.SrtpOrderSortRateVo;

import java.util.List;

public interface ISrtpOrderService {

    /**
     * 分页获取订单信息
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<SrtpOrder> listOrders(Integer pageNum, Integer pageSize);

    /**
     * 根据类型获取订单比率
     * @return
     */
    List<SrtpOrderSortRateVo> listOrderSortRate();

    /**
     * 获取订单基础信息，订单详情页
     * @param orderId
     * @return
     */
    SrtpOrderDetailVo getOrderBaseInfo(Integer orderId);
}
