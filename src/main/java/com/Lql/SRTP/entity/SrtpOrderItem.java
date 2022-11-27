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
public class SrtpOrderItem implements Serializable {
    private Integer id;

    /**
    * 订单id
    */
    private Integer oid;

    /**
    * 商品id
    */
    private Integer pid;

    /**
    * 选择商品名
    */
    private String pname;

    /**
    * 选择商品图片
    */
    private String pimage;

    /**
    * 选择商品价格
    */
    private Double pprice;

    /**
    * 选择商品数量
    */
    private Integer pnum;

    /**
    * 选择商品总价
    */
    private Double ptotalprice;

    /**
    * 选择商品时间
    */
    private Date pcreatetime;

    /**
    * 修改商品时间
    */
    private Date pmodifiedtime;

    /**
    * 选择商品人
    */
    private String pcreateruser;

    /**
    * 修改商品人
    */
    private String pmodifieduser;

    /**
    * 订单类型1出库2入库
    */
    private Integer pstate;

    /**
    * 商品剩余数
    */
    private Integer prest;

    private static final long serialVersionUID = 1L;
}