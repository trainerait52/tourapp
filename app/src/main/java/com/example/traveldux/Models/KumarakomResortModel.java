package com.example.traveldux.Models;

public class KumarakomResortModel {
    String name,price,rating,discount,img_url,type;

    public KumarakomResortModel() {
    }

    public KumarakomResortModel(String name, String price, String rating, String discount, String img_url, String type) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.discount = discount;
        this.img_url = img_url;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
