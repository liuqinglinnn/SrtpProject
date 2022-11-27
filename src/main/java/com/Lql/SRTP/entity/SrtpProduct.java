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
public class SrtpProduct implements Serializable {
    /**
    * 商品id
    */
    private Integer id;

    /**
    * 所属公司
    */
    private String company;

    /**
    * 商品名
    */
    private String title;

    /**
    * 商品价格
    */
    private Double price;

    /**
    * 商品库存数量
    */
    private Integer num;

    /**
    * 商品图片
    */
    private String image;

    /**
    * 商品状态 1：上架 2：下架 3：删除
    */
    private Integer status;

    /**
    * 商品所在货架id
    */
    private Integer sid;

    /**
    * 商品优先级
    */
    private Integer priority;

    /**
    * 周转量
    */
    private Double iton;

    /**
    * 周转率
    */
    private Double itom;

    private static final long serialVersionUID = 1L;
}