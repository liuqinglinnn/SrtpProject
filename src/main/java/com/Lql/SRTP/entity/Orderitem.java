package com.Lql.SRTP.entity;

import java.io.Serializable;
import java.util.Objects;

public class Orderitem implements Serializable {
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

    @Override
    public String toString() {
        return "Orderitem{" +
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
                ", pmodifieduser='" + pmodifieduser + '\'' +
                ", pcreateruser='" + pcreateruser + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Orderitem)) return false;
        Orderitem orderitem = (Orderitem) o;
        return id.equals(orderitem.id) && oid.equals(orderitem.oid) && pid.equals(orderitem.pid) && pname.equals(orderitem.pname) && Objects.equals(pimage, orderitem.pimage) && Objects.equals(pprice, orderitem.pprice) && Objects.equals(pnum, orderitem.pnum) && Objects.equals(ptotalprice, orderitem.ptotalprice) && Objects.equals(pcreatetime, orderitem.pcreatetime) && Objects.equals(pmodifiedtime, orderitem.pmodifiedtime) && Objects.equals(pmodifieduser, orderitem.pmodifieduser) && Objects.equals(pcreateruser, orderitem.pcreateruser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, oid, pid, pname, pimage, pprice, pnum, ptotalprice, pcreatetime, pmodifiedtime, pmodifieduser, pcreateruser);
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

    public String getPmodifieduser() {
        return pmodifieduser;
    }

    public void setPmodifieduser(String pmodifieduser) {
        this.pmodifieduser = pmodifieduser;
    }

    public String getPcreateruser() {
        return pcreateruser;
    }

    public void setPcreateruser(String pcreateruser) {
        this.pcreateruser = pcreateruser;
    }
}
