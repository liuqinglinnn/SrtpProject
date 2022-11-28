package com.Lql.SRTP.service.Impl;

import com.Lql.SRTP.dao.SrtpOrderItemMapper;
import com.Lql.SRTP.dao.SrtpOrderMapper;
import com.Lql.SRTP.dao.SrtpProductMapper;
import com.Lql.SRTP.entity.SrtpOrder;
import com.Lql.SRTP.entity.SrtpOrderItem;
import com.Lql.SRTP.entity.SrtpProduct;
import com.Lql.SRTP.entity.vo.SrtpOrderDetailVo;
import com.Lql.SRTP.entity.vo.SrtpOrderSortRateVo;
import com.Lql.SRTP.entity.vo.SrtpProductCardVo;
import com.Lql.SRTP.service.ISrtpOrderService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("SrtpOrderService")
public class SrtpOrderServiceImpl implements ISrtpOrderService {

    @Autowired
    private SrtpOrderMapper orderMapper;

    @Autowired
    private SrtpProductMapper productMapper;

    @Autowired
    private SrtpOrderItemMapper orderItemMapper;

    @Override
    public List<SrtpOrder> listOrders(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<SrtpOrder> srtpOrders = orderMapper.selectByAll(new SrtpOrder());
        return srtpOrders;
    }

    @Override
    public List<SrtpOrderSortRateVo> listOrderSortRate() {
        return orderMapper.selectOrderSortRate();
    }

    @Override
    public SrtpOrderDetailVo getOrderBaseInfo(Integer orderId) {
        SrtpOrderDetailVo baseInfo = orderMapper.selectBaseOrderInfo(orderId);
        if (baseInfo == null) {
            throw new RuntimeException("该订单不存在，请检查ID是否有误");
        }
        List<SrtpOrderItem> orderItems = orderItemMapper.selectByAll(SrtpOrderItem.builder().oid(orderId).build());
        ArrayList<SrtpProductCardVo> productCardVos = new ArrayList<>();
        for (SrtpOrderItem orderItem : orderItems) {
            SrtpProductCardVo productCardVo = productMapper.selectProductCardInfo(orderItem.getPid(), orderId);
            productCardVos.add(productCardVo);
        }
        baseInfo.setProductList(productCardVos);
        return baseInfo;
    }


}
