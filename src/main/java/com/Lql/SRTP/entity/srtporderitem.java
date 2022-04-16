package com.Lql.SRTP.entity;

import java.io.Serializable;
import java.util.Objects;

public class srtporderitem implements Serializable {
    private Integer id;
    private Integer oid;
    private Integer pid;
    private String pname;
    private String pimage;
    private Long pprice;
    private Integer pnum;
    private Long ptotalprice;

    @Override
    public String toString() {
        return "srtporderitem{" +
                "id=" + id +
                ", oid=" + oid +
                ", pid=" + pid +
                ", pname='" + pname + '\'' +
                ", pimage='" + pimage + '\'' +
                ", pprice=" + pprice +
                ", pnum=" + pnum +
                ", ptotalprice=" + ptotalprice +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof srtporderitem)) return false;
        srtporderitem that = (srtporderitem) o;
        return id.equals(that.id) && oid.equals(that.oid) && pid.equals(that.pid) && pname.equals(that.pname) && Objects.equals(pimage, that.pimage) && Objects.equals(pprice, that.pprice) && Objects.equals(pnum, that.pnum) && Objects.equals(ptotalprice, that.ptotalprice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, oid, pid, pname, pimage, pprice, pnum, ptotalprice);
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
}
