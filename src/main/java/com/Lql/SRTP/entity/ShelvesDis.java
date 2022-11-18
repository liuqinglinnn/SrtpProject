package com.Lql.SRTP.entity;

import java.util.Objects;

public class ShelvesDis {
    private Integer  x1;
    private Integer y1;
    private Integer  x2;
    private Integer y2;
    private Integer s1;
    private Integer s2;
    private Integer g1;
    private Integer g2;
    private Integer num1;
    private Integer num2;
    private Integer score1;
    private Integer score2;
    private Integer dis;

    @Override
    public String toString() {
        return "ShelvesDis{" +
                "x1=" + x1 +
                ", y1=" + y1 +
                ", x2=" + x2 +
                ", y2=" + y2 +
                ", s1=" + s1 +
                ", s2=" + s2 +
                ", g1=" + g1 +
                ", g2=" + g2 +
                ", num1=" + num1 +
                ", num2=" + num2 +
                ", score1=" + score1 +
                ", score2=" + score2 +
                ", dis=" + dis +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShelvesDis that = (ShelvesDis) o;
        return Objects.equals(x1, that.x1) && Objects.equals(y1, that.y1) && Objects.equals(x2, that.x2) && Objects.equals(y2, that.y2) && Objects.equals(s1, that.s1) && Objects.equals(s2, that.s2) && Objects.equals(g1, that.g1) && Objects.equals(g2, that.g2) && Objects.equals(num1, that.num1) && Objects.equals(num2, that.num2) && Objects.equals(score1, that.score1) && Objects.equals(score2, that.score2) && Objects.equals(dis, that.dis);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x1, y1, x2, y2, s1, s2, g1, g2, num1, num2, score1, score2, dis);
    }

    public Integer getX1() {
        return x1;
    }

    public void setX1(Integer x1) {
        this.x1 = x1;
    }

    public Integer getY1() {
        return y1;
    }

    public void setY1(Integer y1) {
        this.y1 = y1;
    }

    public Integer getX2() {
        return x2;
    }

    public void setX2(Integer x2) {
        this.x2 = x2;
    }

    public Integer getY2() {
        return y2;
    }

    public void setY2(Integer y2) {
        this.y2 = y2;
    }

    public Integer getS1() {
        return s1;
    }

    public void setS1(Integer s1) {
        this.s1 = s1;
    }

    public Integer getS2() {
        return s2;
    }

    public void setS2(Integer s2) {
        this.s2 = s2;
    }

    public Integer getG1() {
        return g1;
    }

    public void setG1(Integer g1) {
        this.g1 = g1;
    }

    public Integer getG2() {
        return g2;
    }

    public void setG2(Integer g2) {
        this.g2 = g2;
    }

    public Integer getNum1() {
        return num1;
    }

    public void setNum1(Integer num1) {
        this.num1 = num1;
    }

    public Integer getNum2() {
        return num2;
    }

    public void setNum2(Integer num2) {
        this.num2 = num2;
    }

    public Integer getScore1() {
        return score1;
    }

    public void setScore1(Integer score1) {
        this.score1 = score1;
    }

    public Integer getScore2() {
        return score2;
    }

    public void setScore2(Integer score2) {
        this.score2 = score2;
    }

    public Integer getDis() {
        return dis;
    }

    public void setDis(Integer dis) {
        this.dis = dis;
    }

    public ShelvesDis(Integer x1, Integer y1, Integer x2, Integer y2, Integer s1, Integer s2, Integer g1, Integer g2, Integer num1, Integer num2, Integer score1, Integer score2, Integer dis) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.s1 = s1;
        this.s2 = s2;
        this.g1 = g1;
        this.g2 = g2;
        this.num1 = num1;
        this.num2 = num2;
        this.score1 = score1;
        this.score2 = score2;
        this.dis = dis;
    }
}
