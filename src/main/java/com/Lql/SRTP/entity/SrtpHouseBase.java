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
public class SrtpHouseBase implements Serializable {
    private Integer id;

    private String name;

    private String place;

    private Double iton;

    private Double itom;

    private Double num1;

    private Double num2;

    private Double num3;

    private Double num4;

    private Double num5;

    private static final long serialVersionUID = 1L;
}