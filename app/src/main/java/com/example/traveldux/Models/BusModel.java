package com.example.traveldux.Models;

public class BusModel {
    String  name,rating,type,img_url,address;

    public BusModel() {
    }

    public BusModel(String name, String rating, String type, String img_url, String address) {
        this.name = name;
        this.rating = rating;
        this.type = type;
        this.img_url = img_url;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
