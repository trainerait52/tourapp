package com.example.traveldux.Models;

public class ResortBookingModel {
    String name,tables,members,date,time,amount;

    public ResortBookingModel(String name, String tables, String members, String date, String time, String amount) {
        this.name = name;
        this.tables = tables;
        this.members = members;
        this.date = date;
        this.time = time;
        this.amount = amount;
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

    public String getMembers() {
        return members;
    }

    public void setMembers(String members) {
        this.members = members;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
