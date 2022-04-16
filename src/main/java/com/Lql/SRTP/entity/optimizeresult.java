package com.Lql.SRTP.entity;

import java.util.Objects;

public class optimizeresult {
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
    private Double score;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof optimizeresult)) return false;
        optimizeresult that = (optimizeresult) o;
        return Objects.equals(id, that.id) && Objects.equals(company, that.company) && Objects.equals(title, that.title) && Objects.equals(price, that.price) && Objects.equals(num, that.num) && Objects.equals(image, that.image) && Objects.equals(status, that.status) && Objects.equals(x, that.x) && Objects.equals(y, that.y) && Objects.equals(sid, that.sid) && Objects.equals(score, that.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, company, title, price, num, image, status, x, y, sid, score);
    }

    @Override
    public String toString() {
        return "optimizeresult{" +
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
                ", score=" + score +
                '}';
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

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
