package com.Lql.SRTP.entity;

import java.util.Objects;

public class Shelves {
    private int id;
    private int sx;
    private int sy;
    private long sv;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Shelves)) return false;
        Shelves that = (Shelves) o;
        return id == that.id && sx == that.sx && sy == that.sy && sv == that.sv;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sx, sy, sv);
    }

    @Override
    public String toString() {
        return "srtpshelves{" +
                "id=" + id +
                ", sx=" + sx +
                ", sy=" + sy +
                ", sv=" + sv +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSx() {
        return sx;
    }

    public void setSx(int sx) {
        this.sx = sx;
    }

    public int getSy() {
        return sy;
    }

    public void setSy(int sy) {
        this.sy = sy;
    }

    public long getSv() {
        return sv;
    }

    public void setSv(long sv) {
        this.sv = sv;
    }
}
