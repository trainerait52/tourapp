package com.example.traveldux.Models;

public class AdminBookingListModel {
    String  amount,date,days,members,name,rooms,time;

    public AdminBookingListModel(String amount, String date, String days, String members, String name, String rooms, String time) {
        this.amount = amount;
        this.date = date;
        this.days = days;
        this.members = members;
        this.name = name;
        this.rooms = rooms;
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

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
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

    public String getRooms() {
        return rooms;
    }

    public void setRooms(String rooms) {
        this.rooms = rooms;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
