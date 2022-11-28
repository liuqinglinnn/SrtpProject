package com.Lql.SRTP.entity.vo;

import lombok.Data;

@Data
public class SrtpProductCardVo {

    /**
     * 商品图片
     */
    private String imgUrl;

    /**
     * 商品名
     */
    private String name;

    /**
     * 商品描述
     */
    private String description;

    /**
     * 商品数量
     */
    private Integer count;

    /**
     * 商品ID
     */
    private Integer id;
}
