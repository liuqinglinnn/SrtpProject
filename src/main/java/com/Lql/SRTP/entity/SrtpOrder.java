package com.Lql.SRTP.entity;

import java.io.Serializable;
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
    private String orderTime;

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

    private static final long serialVersionUID = 1L;
}