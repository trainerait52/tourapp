package com.example.traveldux.Models;

public class AdminPaymentListModel {
    String  amount,cvc,exp,name,number;

    public AdminPaymentListModel(String amount, String cvc, String exp, String name, String number) {
        this.amount = amount;
        this.cvc = cvc;
        this.exp = exp;
        this.name = name;
        this.number = number;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCvc() {
        return cvc;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
