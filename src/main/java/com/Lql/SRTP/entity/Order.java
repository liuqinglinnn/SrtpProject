package com.Lql.SRTP.entity;

import java.io.Serializable;
import java.util.Objects;

public class Order implements Serializable {
    private Integer oid;
    private Long order_price;
    private String order_createtime;
    private String order_reviewer;
    private String order_sort;
    private String order_note;

    @Override
    public String toString() {
        return "Order{" +
                "oid=" + oid +
                ", order_price=" + order_price +
                ", order_createtime='" + order_createtime + '\'' +
                ", order_reviewer='" + order_reviewer + '\'' +
                ", order_sort='" + order_sort + '\'' +
                ", order_note='" + order_note + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return oid.equals(order.oid) && Objects.equals(order_price, order.order_price) && Objects.equals(order_createtime, order.order_createtime) && Objects.equals(order_reviewer, order.order_reviewer) && Objects.equals(order_sort, order.order_sort) && Objects.equals(order_note, order.order_note);
    }

    @Override
    public int hashCode() {
        return Objects.hash(oid, order_price, order_createtime, order_reviewer, order_sort, order_note);
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Long getOrder_price() {
        return order_price;
    }

    public void setOrder_price(Long order_price) {
        this.order_price = order_price;
    }

    public String getOrder_createtime() {
        return order_createtime;
    }

    public void setOrder_createtime(String order_createtime) {
        this.order_createtime = order_createtime;
    }

    public String getOrder_reviewer() {
        return order_reviewer;
    }

    public void setOrder_reviewer(String order_reviewer) {
        this.order_reviewer = order_reviewer;
    }

    public String getOrder_sort() {
        return order_sort;
    }

    public void setOrder_sort(String order_sort) {
        this.order_sort = order_sort;
    }

    public String getOrder_note() {
        return order_note;
    }

    public void setOrder_note(String order_note) {
        this.order_note = order_note;
    }
}
