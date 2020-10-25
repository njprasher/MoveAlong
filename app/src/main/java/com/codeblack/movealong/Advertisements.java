package com.codeblack.movealong;

import java.util.ArrayList;
import java.util.Date;

public class Advertisements {
    int aId;
    String uId;
    String body;
    String title;
    Date date_Posted;
    String for_number_of_Person;
    String place;
    Date time_To_Move;
    Float budget;
    Boolean is_active;

    static ArrayList<Advertisements> advertisementsArray = new ArrayList<Advertisements>();

    public Advertisements( String body, String title,
                          Date date_Posted, String for_number_of_Person,
                          String place, Date time_To_Move, Float budget, Boolean is_active) {
//        this.uId = uId;
        this.body = body;
        this.title = title;
        this.date_Posted = date_Posted;
        this.for_number_of_Person = for_number_of_Person;
        this.place = place;
        this.time_To_Move = time_To_Move;
        this.budget = budget;
        this.is_active = is_active;
    }

    public int getaId() {
        return aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate_Posted() {
        return date_Posted;
    }

    public void setDate_Posted(Date date_Posted) {
        this.date_Posted = date_Posted;
    }

    public String getFor_number_of_Person() {
        return for_number_of_Person;
    }

    public void setFor_number_of_Person(String for_number_of_Person) {
        this.for_number_of_Person = for_number_of_Person;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Date getTime_To_Move() {
        return time_To_Move;
    }

    public void setTime_To_Move(Date time_To_Move) {
        this.time_To_Move = time_To_Move;
    }

    public Float getBudget() {
        return budget;
    }

    public void setBudget(Float budget) {
        this.budget = budget;
    }

    public Boolean getIs_active() {
        return is_active;
    }

    public void setIs_active(Boolean is_active) {
        this.is_active = is_active;
    }
}
