package com.Lql.SRTP.entity.vo;

import lombok.Data;

@Data
public class SrtpOrderSortRateVo {

    /**
     * 订单类型
     */
    private String orderSort;

    /**
     * 该订单类型所占比例
     */
    private Double rate;
}
