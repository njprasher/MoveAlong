package com.codeblack.movealong.Utilities;

import java.util.ArrayList;

public class MyListData {
    private String title;
    private String number_of_person;
    private String budget;
    private String description;
//    private String imgId;
    private String address;
    private String timetomove;
    private String is_active;
    private String uId;
    private String prefer;


    public static ArrayList<MyListData> myListData = new ArrayList<MyListData>();

    public MyListData(String title, String number_of_person, String budget,
                      String description, String address,
                      String timetomove, String is_active, String uId, String prefer) {
        this.title = title;
        this.number_of_person = number_of_person;
        this.budget = budget;
        this.description = description;
//        this.imgId = imgId;
        this.address = address;
        this.timetomove = timetomove;
        this.is_active = is_active;
        this.uId = uId;
        this.prefer = prefer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNumber_of_person() {
        return number_of_person;
    }

    public void setNumber_of_person(String number_of_person) {
        this.number_of_person = number_of_person;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public String getImgId() {
//        return imgId;
//    }
//
//    public void setImgId(String imgId) {
//        this.imgId = imgId;
//    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTimetomove() {
        return timetomove;
    }

    public void setTimetomove(String timetomove) {
        this.timetomove = timetomove;
    }

    public String getIs_active() {
        return is_active;
    }

    public void setIs_active(String is_active) {
        this.is_active = is_active;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getPrefer() {
        return prefer;
    }

    public void setPrefer(String prefer) {
        this.prefer = prefer;
    }
}
