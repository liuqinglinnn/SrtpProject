package com.Lql.SRTP.entity;

import java.io.Serializable;
import java.util.Objects;

public class OrderItem implements Serializable {
    private Integer id;
    private Integer oid;
    private Integer pid;
    private String pname;
    private String pimage;
    private Long pprice;
    private Integer pnum;
    private Long ptotalprice;
    private String pcreatetime;
    private String pmodifiedtime;
    private String pcreateruser;
    private String pmodifieduser;
    private Integer pstate;
    private  Integer prest;

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", oid=" + oid +
                ", pid=" + pid +
                ", pname='" + pname + '\'' +
                ", pimage='" + pimage + '\'' +
                ", pprice=" + pprice +
                ", pnum=" + pnum +
                ", ptotalprice=" + ptotalprice +
                ", pcreatetime='" + pcreatetime + '\'' +
                ", pmodifiedtime='" + pmodifiedtime + '\'' +
                ", pcreateruser='" + pcreateruser + '\'' +
                ", pmodifieduser='" + pmodifieduser + '\'' +
                ", pstate=" + pstate +
                ", prest=" + prest +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderitem = (OrderItem) o;
        return Objects.equals(id, orderitem.id) && Objects.equals(oid, orderitem.oid) && Objects.equals(pid, orderitem.pid) && Objects.equals(pname, orderitem.pname) && Objects.equals(pimage, orderitem.pimage) && Objects.equals(pprice, orderitem.pprice) && Objects.equals(pnum, orderitem.pnum) && Objects.equals(ptotalprice, orderitem.ptotalprice) && Objects.equals(pcreatetime, orderitem.pcreatetime) && Objects.equals(pmodifiedtime, orderitem.pmodifiedtime) && Objects.equals(pcreateruser, orderitem.pcreateruser) && Objects.equals(pmodifieduser, orderitem.pmodifieduser) && Objects.equals(pstate, orderitem.pstate) && Objects.equals(prest, orderitem.prest);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, oid, pid, pname, pimage, pprice, pnum, ptotalprice, pcreatetime, pmodifiedtime, pcreateruser, pmodifieduser, pstate, prest);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPimage() {
        return pimage;
    }

    public void setPimage(String pimage) {
        this.pimage = pimage;
    }

    public Long getPprice() {
        return pprice;
    }

    public void setPprice(Long pprice) {
        this.pprice = pprice;
    }

    public Integer getPnum() {
        return pnum;
    }

    public void setPnum(Integer pnum) {
        this.pnum = pnum;
    }

    public Long getPtotalprice() {
        return ptotalprice;
    }

    public void setPtotalprice(Long ptotalprice) {
        this.ptotalprice = ptotalprice;
    }

    public String getPcreatetime() {
        return pcreatetime;
    }

    public void setPcreatetime(String pcreatetime) {
        this.pcreatetime = pcreatetime;
    }

    public String getPmodifiedtime() {
        return pmodifiedtime;
    }

    public void setPmodifiedtime(String pmodifiedtime) {
        this.pmodifiedtime = pmodifiedtime;
    }

    public String getPcreateruser() {
        return pcreateruser;
    }

    public void setPcreateruser(String pcreateruser) {
        this.pcreateruser = pcreateruser;
    }

    public String getPmodifieduser() {
        return pmodifieduser;
    }

    public void setPmodifieduser(String pmodifieduser) {
        this.pmodifieduser = pmodifieduser;
    }

    public Integer getPstate() {
        return pstate;
    }

    public void setPstate(Integer pstate) {
        this.pstate = pstate;
    }

    public Integer getPrest() {
        return prest;
    }

    public void setPrest(Integer prest) {
        this.prest = prest;
    }

    public OrderItem(Integer id, Integer oid, Integer pid, String pname, String pimage, Long pprice, Integer pnum, Long ptotalprice, String pcreatetime, String pmodifiedtime, String pcreateruser, String pmodifieduser, Integer pstate, Integer prest) {
        this.id = id;
        this.oid = oid;
        this.pid = pid;
        this.pname = pname;
        this.pimage = pimage;
        this.pprice = pprice;
        this.pnum = pnum;
        this.ptotalprice = ptotalprice;
        this.pcreatetime = pcreatetime;
        this.pmodifiedtime = pmodifiedtime;
        this.pcreateruser = pcreateruser;
        this.pmodifieduser = pmodifieduser;
        this.pstate = pstate;
        this.prest = prest;
    }
}
