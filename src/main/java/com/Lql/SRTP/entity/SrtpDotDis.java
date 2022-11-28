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
public class SrtpDotDis implements Serializable {
    private Integer m1;

    private Integer n1;

    private Integer m2;

    private Integer n2;

    private Integer dis;

    private static final long serialVersionUID = 1L;
}