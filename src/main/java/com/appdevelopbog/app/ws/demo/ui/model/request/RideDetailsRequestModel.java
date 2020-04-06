package com.appdevelopbog.app.ws.demo.ui.model.request;

import com.appdevelopbog.app.ws.demo.shared.DateTime;
import com.appdevelopbog.app.ws.demo.shared.LocationInfo;

public class RideDetailsRequestModel {
    private String aid;
    private LocationInfo location_info;
    private DateTime date_time;
    private CarInfo car_info;
    private int max_passengers;
    private double amount_per_passenger;
    private String conditions;

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public LocationInfo getLocation_info() {
        return location_info;
    }

    public void setLocation_info(LocationInfo location_info) {
        this.location_info = location_info;
    }

    public DateTime getDate_time() {
        return date_time;
    }

    public void setDate_time(DateTime date_time) {
        this.date_time = date_time;
    }

    public Carinto getCar_info() {
        return car_info;
    }

    public void setCar_info(Carinto car_info) {
        this.car_info = car_info;
    }

    public int getMax_passengers() {
        return max_passengers;
    }

    public void setMax_passengers(int max_passengers) {
        this.max_passengers = max_passengers;
    }

    public double getAmount_per_passenger() {
        return amount_per_passenger;
    }

    public void setAmount_per_passenger(double amount_per_passenger) {
        this.amount_per_passenger = amount_per_passenger;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }
}
