package com.Lql.SRTP.entity;

import java.util.Objects;

public class Dotdis {
    private Integer m1;
    private Integer n1;
    private Integer m2;
    private Integer n2;
    private Integer dis;

    @Override
    public String toString() {
        return "Dotdis{" +
                "m1=" + m1 +
                ", n1=" + n1 +
                ", m2=" + m2 +
                ", n2=" + n2 +
                ", dis=" + dis +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dotdis dotdis = (Dotdis) o;
        return Objects.equals(m1, dotdis.m1) && Objects.equals(n1, dotdis.n1) && Objects.equals(m2, dotdis.m2) && Objects.equals(n2, dotdis.n2) && Objects.equals(dis, dotdis.dis);
    }

    @Override
    public int hashCode() {
        return Objects.hash(m1, n1, m2, n2, dis);
    }

    public Integer getM1() {
        return m1;
    }

    public void setM1(Integer m1) {
        this.m1 = m1;
    }

    public Integer getN1() {
        return n1;
    }

    public void setN1(Integer n1) {
        this.n1 = n1;
    }

    public Integer getM2() {
        return m2;
    }

    public void setM2(Integer m2) {
        this.m2 = m2;
    }

    public Integer getN2() {
        return n2;
    }

    public void setN2(Integer n2) {
        this.n2 = n2;
    }

    public Integer getDis() {
        return dis;
    }

    public void setDis(Integer dis) {
        this.dis = dis;
    }

    public Dotdis(Integer m1, Integer n1, Integer m2, Integer n2, Integer dis) {
        this.m1 = m1;
        this.n1 = n1;
        this.m2 = m2;
        this.n2 = n2;
        this.dis = dis;
    }
}
