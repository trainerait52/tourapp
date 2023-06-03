package com.example.traveldux.Models;

public class ViewHomeModel {

    String name, type, description, text, img_url, address;

    public ViewHomeModel() {
    }

    public ViewHomeModel(String name, String type, String description, String text, String img_url, String address) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.text = text;
        this.img_url = img_url;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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
