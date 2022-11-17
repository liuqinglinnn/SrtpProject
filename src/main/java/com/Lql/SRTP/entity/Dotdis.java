package com.Lql.SRTP.entity;

import java.util.Objects;

public class Dotdis {
    private Integer m;
    private Integer n;
    private Integer dis;

    @Override
    public String toString() {
        return "Dotdis{" +
                "m=" + m +
                ", n=" + n +
                ", dis=" + dis +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dotdis dotdis = (Dotdis) o;
        return Objects.equals(m, dotdis.m) && Objects.equals(n, dotdis.n) && Objects.equals(dis, dotdis.dis);
    }

    @Override
    public int hashCode() {
        return Objects.hash(m, n, dis);
    }

    public Integer getM() {
        return m;
    }

    public void setM(Integer m) {
        this.m = m;
    }

    public Integer getN() {
        return n;
    }

    public void setN(Integer n) {
        this.n = n;
    }

    public Integer getDis() {
        return dis;
    }

    public void setDis(Integer dis) {
        this.dis = dis;
    }

    public Dotdis(Integer m, Integer n, Integer dis) {
        this.m = m;
        this.n = n;
        this.dis = dis;
    }
}
