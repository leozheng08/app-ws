package com.appdevelopbog.app.ws.demo.io.entity;



import javax.persistence.*;
import java.io.Serializable;


@Entity(name="Account")
public class AccountEntity implements Serializable {
    public static final long serialVersionUID= -5427267198455890486L;

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String aid;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, length=12)
    private String phone;

    @Column(nullable = false, length = 1000)
    private String picture;

    @Column(nullable = false)
    private boolean isActived;

    @Column(name = "created_date")
    private String createdDate;

    public String getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
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
