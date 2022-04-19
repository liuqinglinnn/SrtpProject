package com.Lql.SRTP.entity;

import java.io.Serializable;
import java.util.Objects;

public class Product implements Serializable {
    private Integer id;
    private String company;
    private String title;
    private Long price;
    private Integer num;
    private String image;
    private Integer status;
    private Long x;
    private Long y;
    private Integer sid;
    private Integer priority;
    private String createtime;
    private String modifiedtime;
    private String createuser;
    private String modifieduser;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", company='" + company + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", num=" + num +
                ", image='" + image + '\'' +
                ", status=" + status +
                ", x=" + x +
                ", y=" + y +
                ", sid=" + sid +
                ", priority=" + priority +
                ", createtime='" + createtime + '\'' +
                ", modifiedtime='" + modifiedtime + '\'' +
                ", createuser='" + createuser + '\'' +
                ", modifieduser='" + modifieduser + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return id.equals(product.id) && Objects.equals(company, product.company) && Objects.equals(title, product.title) && Objects.equals(price, product.price) && Objects.equals(num, product.num) && Objects.equals(image, product.image) && Objects.equals(status, product.status) && Objects.equals(x, product.x) && Objects.equals(y, product.y) && Objects.equals(sid, product.sid) && Objects.equals(priority, product.priority) && Objects.equals(createtime, product.createtime) && Objects.equals(modifiedtime, product.modifiedtime) && Objects.equals(createuser, product.createuser) && Objects.equals(modifieduser, product.modifieduser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, company, title, price, num, image, status, x, y, sid, priority, createtime, modifiedtime, createuser, modifieduser);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getX() {
        return x;
    }

    public void setX(Long x) {
        this.x = x;
    }

    public Long getY() {
        return y;
    }

    public void setY(Long y) {
        this.y = y;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getModifiedtime() {
        return modifiedtime;
    }

    public void setModifiedtime(String modifiedtime) {
        this.modifiedtime = modifiedtime;
    }

    public String getCreateuser() {
        return createuser;
    }

    public void setCreateuser(String createuser) {
        this.createuser = createuser;
    }

    public String getModifieduser() {
        return modifieduser;
    }

    public void setModifieduser(String modifieduser) {
        this.modifieduser = modifieduser;
    }
}
