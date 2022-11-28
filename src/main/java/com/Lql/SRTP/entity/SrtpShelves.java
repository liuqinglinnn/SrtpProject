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
public class SrtpShelves implements Serializable {
    /**
    * id
    */
    private Integer id;

    /**
    * 四个角的坐标
    */
    private Integer sx1;

    private Integer sx2;

    private Integer sy1;

    private Integer sy2;

    /**
    * 货架的评分
    */
    private Double sv;

    /**
    * 商品id
    */
    private Integer pid;

    private static final long serialVersionUID = 1L;
}