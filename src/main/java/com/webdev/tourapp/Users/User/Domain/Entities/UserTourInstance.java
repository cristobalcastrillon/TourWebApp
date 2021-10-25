package com.webdev.tourapp.Users.User.Domain.Entities;

import java.util.Date;
import java.util.HashMap;

public class UserTourInstance {
    Date tourDate;
    String tourInstanceID;
    Integer tourNumberOfPersons;
    Double tourTotalPrice;
    String tourInstanceStatus;

    public UserTourInstance(String tourInstanceID, Integer tourNumberOfPersons
            , Double tourTotalPrice, String tourInstanceStatus, Date tourDate) {
        this.tourDate = tourDate;
        this.tourInstanceID = tourInstanceID;
        this.tourNumberOfPersons = tourNumberOfPersons;
        this.tourTotalPrice = tourTotalPrice;
        this.tourInstanceStatus = tourInstanceStatus;
    }
    public HashMap<String, Object> dataDB()
    {
        return new HashMap<>(){{
            put("tourInstanceID", tourInstanceID);
            put("tourNumberOfPersons", tourNumberOfPersons);
            put("tourTotalPrice", tourTotalPrice);
            put("tourInstanceStatus", tourInstanceStatus);
            put("tourDate", tourDate);
        }};
    }

    public Date getTourDate() {
        return tourDate;
    }

    public void setTourDate(Date tourDate) {
        this.tourDate = tourDate;
    }

    public String getTourInstanceID() {
        return tourInstanceID;
    }

    public void setTourInstanceID(String tourInstanceID) {
        this.tourInstanceID = tourInstanceID;
    }

    public Integer getTourNumberOfPersons() {
        return tourNumberOfPersons;
    }

    public void setTourNumberOfPersons(Integer tourNumberOfPersons) {
        this.tourNumberOfPersons = tourNumberOfPersons;
    }

    public Double getTourTotalPrice() {
        return tourTotalPrice;
    }

    public void setTourTotalPrice(Double tourTotalPrice) {
        this.tourTotalPrice = tourTotalPrice;
    }

    public String getTourInstanceStatus() {
        return tourInstanceStatus;
    }

    public void setTourInstanceStatus(String tourInstanceStatus) {
        this.tourInstanceStatus = tourInstanceStatus;
    }

    private UserTourInstance(){}

}
