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
public class SrtpShelvesDis implements Serializable {
    private Integer x1;

    private Integer y1;

    private Integer x2;

    private Integer y2;

    /**
    * 货架shelves
    */
    private Integer s1;

    private Integer s2;

    /**
    * 货物goods
    */
    private Integer g1;

    private Integer g2;

    /**
    * 相似度
    */
    private Double num1;

    private Double num2;

    /**
    * 货物的好坏程度
    */
    private Double score1;

    private Double score2;

    /**
    * 两货架距离
    */
    private Integer dis;

    private static final long serialVersionUID = 1L;
}