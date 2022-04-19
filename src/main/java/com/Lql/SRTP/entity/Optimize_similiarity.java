package com.Lql.SRTP.entity;

import java.io.Serializable;
import java.util.Objects;

public class Optimize_similiarity implements Serializable {
    private Integer compare1;
    private Integer compare2;
    private Double simnum;
    private Double sume;

    @Override
    public String toString() {
        return "Optimize_similiarity{" +
                "compare1=" + compare1 +
                ", compare2=" + compare2 +
                ", simnum=" + simnum +
                ", sume=" + sume +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Optimize_similiarity)) return false;
        Optimize_similiarity that = (Optimize_similiarity) o;
        return Objects.equals(compare1, that.compare1) && Objects.equals(compare2, that.compare2) && Objects.equals(simnum, that.simnum) && Objects.equals(sume, that.sume);
    }

    @Override
    public int hashCode() {
        return Objects.hash(compare1, compare2, simnum, sume);
    }

    public Integer getCompare1() {
        return compare1;
    }

    public void setCompare1(Integer compare1) {
        this.compare1 = compare1;
    }

    public Integer getCompare2() {
        return compare2;
    }

    public void setCompare2(Integer compare2) {
        this.compare2 = compare2;
    }

    public Double getSimnum() {
        return simnum;
    }

    public void setSimnum(Double simnum) {
        this.simnum = simnum;
    }

    public Double getSume() {
        return sume;
    }

    public void setSume(Double sume) {
        this.sume = sume;
    }
}
