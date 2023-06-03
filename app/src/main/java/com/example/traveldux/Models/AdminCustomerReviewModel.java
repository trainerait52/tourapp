package com.example.traveldux.Models;

public class AdminCustomerReviewModel {
    String name,num,reviewsubmit,txtreview;

    public AdminCustomerReviewModel(String name, String num, String reviewsubmit, String txtreview) {
        this.name = name;
        this.num = num;
        this.reviewsubmit = reviewsubmit;
        this.txtreview = txtreview;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getReviewsubmit() {
        return reviewsubmit;
    }

    public void setReviewsubmit(String reviewsubmit) {
        this.reviewsubmit = reviewsubmit;
    }

    public String getTxtreview() {
        return txtreview;
    }

    public void setTxtreview(String txtreview) {
        this.txtreview = txtreview;
    }
}
