package com.example.traveldux.Models;

public class ReviewModel {
    String name,num,txtreview,reviewsubmit ;

    public ReviewModel(String name, String num, String txtreview, String reviewsubmit) {
        this.name = name;
        this.num = num;
        this.txtreview = txtreview;
        this.reviewsubmit = reviewsubmit;
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

    public String getTxtreview() {
        return txtreview;
    }

    public void setTxtreview(String txtreview) {
        this.txtreview = txtreview;
    }

    public String getReviewsubmit() {
        return reviewsubmit;
    }

    public void setReviewsubmit(String reviewsubmit) {
        this.reviewsubmit = reviewsubmit;
    }
}
