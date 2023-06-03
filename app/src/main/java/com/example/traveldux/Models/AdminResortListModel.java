package com.example.traveldux.Models;

public class AdminResortListModel {
    String  amount,date,members,name,tables,time;

    public AdminResortListModel(String amount, String date, String members, String name, String tables, String time) {
        this.amount = amount;
        this.date = date;
        this.members = members;
        this.name = name;
        this.tables = tables;
        this.time = time;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMembers() {
        return members;
    }

    public void setMembers(String members) {
        this.members = members;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTables() {
        return tables;
    }

    public void setTables(String tables) {
        this.tables = tables;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
