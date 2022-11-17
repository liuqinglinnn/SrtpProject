package com.Lql.SRTP.entity;

import java.util.Objects;

public class Dot {
    private Integer id;
    private Integer shelves;
    private Integer x;
    private Integer y;

    public Dot(Integer id, Integer shelves, Integer x, Integer y) {
        this.id = id;
        this.shelves = shelves;
        this.x = x;
        this.y = y;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getShelves() {
        return shelves;
    }

    public void setShelves(Integer shelves) {
        this.shelves = shelves;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dot dot = (Dot) o;
        return id.equals(dot.id) && Objects.equals(shelves, dot.shelves) && Objects.equals(x, dot.x) && Objects.equals(y, dot.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, shelves, x, y);
    }

    @Override
    public String toString() {
        return "Dot{" +
                "id=" + id +
                ", shelves=" + shelves +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
