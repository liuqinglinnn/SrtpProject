package com.Lql.SRTP.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SrtpOrder implements Serializable {
    /**
     * 订单号
     */
    private Integer oid;

    /**
     * 总价
     */
    private Long orderPrice;

    /**
     * 时间
     */
    private Date orderTime;

    /**
     * 审核人
     */
    private String orderReviewer;

    /**
     * 分类
     */
    private String orderSort;

    /**
     * 订单备注
     */
    private String orderNote;

    /**
     * 订单状态（0 未入库，1 上架，2 下架，3 分拣，4 出库）
     */
    private Integer orderStatus;

    /**
     * 入库口号
     */
    private Integer orderInNum;

    /**
     * 对应的company
     */
    private String orderToCompany;

    private static final long serialVersionUID = 1L;
}