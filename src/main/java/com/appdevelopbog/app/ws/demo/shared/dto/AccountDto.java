package com.appdevelopbog.app.ws.demo.shared.dto;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AccountDto implements Serializable {
    public static final long serialVersionUID = 87005558764501587L;
    private long id;
    private String aid;
    private String firstName;
    private String lastName;
    private String phone;
    private String picture;
    private boolean isActived;
    private String createdDate;

    public AccountDto() {
    }

    public String getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(String date){
        this.createdDate = date;
    }
    public void setCreatedDate() {
        Date calendarDate = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        this.createdDate = dateFormat.format(calendarDate);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public boolean getIsActived() {
        return isActived;
    }

    public void setIsActived(boolean actived) {
        isActived = actived;
    }
}
