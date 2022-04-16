package com.Lql.SRTP.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class srtporder implements Serializable {
    private Integer oid;
    private Long orderprice;
    private String ordertime;
    private String orderreviewer;
    private String ordersort;
    private String ordernote;

    @Override
    public String toString() {
        return "srtporder{" +
                "oid=" + oid +
                ", orderprice=" + orderprice +
                ", ordertime='" + ordertime + '\'' +
                ", orderreviewer='" + orderreviewer + '\'' +
                ", ordersort='" + ordersort + '\'' +
                ", ordernote='" + ordernote + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof srtporder)) return false;
        srtporder srtporder = (srtporder) o;
        return oid.equals(srtporder.oid) && Objects.equals(orderprice, srtporder.orderprice) && Objects.equals(ordertime, srtporder.ordertime) && Objects.equals(orderreviewer, srtporder.orderreviewer) && Objects.equals(ordersort, srtporder.ordersort) && Objects.equals(ordernote, srtporder.ordernote);
    }

    @Override
    public int hashCode() {
        return Objects.hash(oid, orderprice, ordertime, orderreviewer, ordersort, ordernote);
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Long getOrderprice() {
        return orderprice;
    }

    public void setOrderprice(Long orderprice) {
        this.orderprice = orderprice;
    }

    public String getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(String ordertime) {
        this.ordertime = ordertime;
    }

    public String getOrderreviewer() {
        return orderreviewer;
    }

    public void setOrderreviewer(String orderreviewer) {
        this.orderreviewer = orderreviewer;
    }

    public String getOrdersort() {
        return ordersort;
    }

    public void setOrdersort(String ordersort) {
        this.ordersort = ordersort;
    }

    public String getOrdernote() {
        return ordernote;
    }

    public void setOrdernote(String ordernote) {
        this.ordernote = ordernote;
    }
}
