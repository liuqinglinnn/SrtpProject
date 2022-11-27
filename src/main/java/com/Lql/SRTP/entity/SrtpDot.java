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
public class SrtpDot implements Serializable {
    /**
    * id
    */
    private Integer id;

    /**
    * 货架id
    */
    private Integer shelves;

    /**
    * x
    */
    private Integer x;

    /**
    * y
    */
    private Integer y;

    private static final long serialVersionUID = 1L;
}