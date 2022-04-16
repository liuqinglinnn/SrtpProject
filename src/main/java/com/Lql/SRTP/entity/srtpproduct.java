package com.Lql.SRTP.entity;

import java.io.Serializable;
import java.util.Objects;

public class srtpproduct implements Serializable {
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

    @Override
    public String toString() {
        return "srtpproduct{" +
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
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof srtpproduct)) return false;
        srtpproduct that = (srtpproduct) o;
        return sid == that.sid && id.equals(that.id) && Objects.equals(company, that.company) && Objects.equals(title, that.title) && Objects.equals(price, that.price) && Objects.equals(num, that.num) && Objects.equals(image, that.image) && Objects.equals(status, that.status) && Objects.equals(x, that.x) && Objects.equals(y, that.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, company, title, price, num, image, status, x, y, sid);
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

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }
}
