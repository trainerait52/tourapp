package com.example.traveldux.Models;

public class PaymentsModel {
    String name,number,exp,cvc,amount;

    public PaymentsModel(String name, String number, String exp, String cvc, String amount) {
        this.name = name;
        this.number = number;
        this.exp = exp;
        this.cvc = cvc;
        this.amount = amount;
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

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public String getCvc() {
        return cvc;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
