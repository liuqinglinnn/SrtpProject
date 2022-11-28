package com.Lql.SRTP.entity.vo;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class SrtpOrderDetailVo {

    /**
     * 公司名
     */
    private String companyName;

    /**
     * 入库口号
     */
    private Integer orderInNum;

    /**
     * 订单状态
     */
    private Integer orderStatus;

    /**
     * 开始时间
     */
    private Date startTime;

    /**
     * 结束时间
     */
    private Date endTime;

    /**
     * 订单编号
     */
    private String orderId;

    /**
     * 拣货人
     */
    private String pickName;

    /**
     * 拣货人手机号
     */
    private String pickPhone;

    /**
     * 订单商品列表
     */
    private List<SrtpProductCardVo> productList;

    /**
     * 商品总数
     */
    private Integer productCount;

    /**
     * 商品总价
     */
    private Double totalPrice;
}
