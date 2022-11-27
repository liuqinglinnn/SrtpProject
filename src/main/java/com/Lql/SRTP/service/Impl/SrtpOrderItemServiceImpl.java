package com.Lql.SRTP.service.Impl;

import com.Lql.SRTP.dao.SrtpOrderItemMapper;
import com.Lql.SRTP.enums.OrderItemTypeEnum;
import com.Lql.SRTP.service.ISrtpOrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("SrtpOrderItemService")
public class SrtpOrderItemServiceImpl implements ISrtpOrderItemService {

    @Autowired
    private SrtpOrderItemMapper orderItemMapper;

    @Override
    public Integer getSumByDays(Integer type, Integer days) {

        // 根据type值判断需要的值
        OrderItemTypeEnum typeEnum = checkType(type);

        // 传参, 从数据库中取值
        return orderItemMapper.getSumByDays(typeEnum.getCode(), days);
    }

    @Override
    public List<Integer> getSumListRecentDays(Integer type, Integer days) {
        // 根据type值判断需要的值
        OrderItemTypeEnum typeEnum = checkType(type);

        // 传参, 从数据库中取值
        return orderItemMapper.getSumListRecentDays(typeEnum.getCode(), days);
    }

    private OrderItemTypeEnum checkType(Integer type) {
        if (!OrderItemTypeEnum.checkTypeValid(type)) {
            throw new RuntimeException("出入库参数有误，请重新输入");
        }
        return OrderItemTypeEnum.getItemTypeFromCode(type);
    }
}
