package com.example.traveldux.Models;

public class ShoppingModel {
    String name,rating,img_url,type,address;

    public ShoppingModel() {
    }

    public ShoppingModel(String name, String rating, String img_url, String type, String address) {
        this.name = name;
        this.rating = rating;
        this.img_url = img_url;
        this.type = type;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
