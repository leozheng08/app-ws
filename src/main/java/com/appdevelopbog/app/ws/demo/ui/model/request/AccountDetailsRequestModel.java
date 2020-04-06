package com.appdevelopbog.app.ws.demo.ui.model.request;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;

public class AccountDetailsRequestModel {
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;

    private String phone;
    private String picture;
    private boolean isActived;

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
