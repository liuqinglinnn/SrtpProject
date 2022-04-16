package com.Lql.SRTP.entity;

import java.util.Objects;

public class productputshelvesentity {
    private Integer pid;
    private Integer sid;
    private Integer x;
    private Integer y;

    @Override
    public String toString() {
        return "productputshelvesentity{" +
                "pid=" + pid +
                ", sid=" + sid +
                ", x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof productputshelvesentity)) return false;
        productputshelvesentity that = (productputshelvesentity) o;
        return pid.equals(that.pid) && sid.equals(that.sid) && x.equals(that.x) && y.equals(that.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pid, sid, x, y);
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
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
}
