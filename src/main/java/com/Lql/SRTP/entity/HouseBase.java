package com.Lql.SRTP.entity;

import java.io.Serializable;
import java.util.Objects;

public class HouseBase implements Serializable {
    Integer id;
    String name;
    String place;
    Double iton;
    Double itom;
    Double num1;
    Double num2;
    Double num3;
    Double num4;
    Double num5;

    @Override
    public String toString() {
        return "HouseBase{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", place='" + place + '\'' +
                ", iton=" + iton +
                ", itom=" + itom +
                ", num1=" + num1 +
                ", num2=" + num2 +
                ", num3=" + num3 +
                ", num4=" + num4 +
                ", num5=" + num5 +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HouseBase housebase = (HouseBase) o;
        return Objects.equals(id, housebase.id) && Objects.equals(name, housebase.name) && Objects.equals(place, housebase.place) && Objects.equals(iton, housebase.iton) && Objects.equals(itom, housebase.itom) && Objects.equals(num1, housebase.num1) && Objects.equals(num2, housebase.num2) && Objects.equals(num3, housebase.num3) && Objects.equals(num4, housebase.num4) && Objects.equals(num5, housebase.num5);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, place, iton, itom, num1, num2, num3, num4, num5);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Double getIton() {
        return iton;
    }

    public void setIton(Double iton) {
        this.iton = iton;
    }

    public Double getItom() {
        return itom;
    }

    public void setItom(Double itom) {
        this.itom = itom;
    }

    public Double getNum1() {
        return num1;
    }

    public void setNum1(Double num1) {
        this.num1 = num1;
    }

    public Double getNum2() {
        return num2;
    }

    public void setNum2(Double num2) {
        this.num2 = num2;
    }

    public Double getNum3() {
        return num3;
    }

    public void setNum3(Double num3) {
        this.num3 = num3;
    }

    public Double getNum4() {
        return num4;
    }

    public void setNum4(Double num4) {
        this.num4 = num4;
    }

    public Double getNum5() {
        return num5;
    }

    public void setNum5(Double num5) {
        this.num5 = num5;
    }

    public HouseBase(Integer id, String name, String place, Double iton, Double itom, Double num1, Double num2, Double num3, Double num4, Double num5) {
        this.id = id;
        this.name = name;
        this.place = place;
        this.iton = iton;
        this.itom = itom;
        this.num1 = num1;
        this.num2 = num2;
        this.num3 = num3;
        this.num4 = num4;
        this.num5 = num5;
    }
}
