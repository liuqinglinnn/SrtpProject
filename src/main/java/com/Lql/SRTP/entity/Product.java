package com.Lql.SRTP.entity;

import java.io.Serializable;
import java.util.Objects;

public class Product implements Serializable {
    private Integer id;
    private String company;
    private String title;
    private Double price;
    private Integer num;
    private String image;
    private Integer status;
    private Integer sid;
    private Integer priority;
    private Double iton;
    private Double itom;

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
                ", sid=" + sid +
                ", priority=" + priority +
                ", iton=" + iton +
                ", itom=" + itom +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(company, product.company) && Objects.equals(title, product.title) && Objects.equals(price, product.price) && Objects.equals(num, product.num) && Objects.equals(image, product.image) && Objects.equals(status, product.status) && Objects.equals(sid, product.sid) && Objects.equals(priority, product.priority) && Objects.equals(iton, product.iton) && Objects.equals(itom, product.itom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, company, title, price, num, image, status, sid, priority, iton, itom);
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
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

    public Double getIton() {
        return iton;
    }

    public void setIton(Double iton) {
        this.iton = iton;
    }

    public Double getItom() {
        return itom;
    }

    public void setItom(Double itom) {
        this.itom = itom;
    }

    public Product(Integer id, String company, String title, Double price, Integer num, String image, Integer status, Integer sid, Integer priority, Double iton, Double itom) {
        this.id = id;
        this.company = company;
        this.title = title;
        this.price = price;
        this.num = num;
        this.image = image;
        this.status = status;
        this.sid = sid;
        this.priority = priority;
        this.iton = iton;
        this.itom = itom;
    }
}
