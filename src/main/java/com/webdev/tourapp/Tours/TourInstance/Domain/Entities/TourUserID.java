package com.webdev.tourapp.Tours.TourInstance.Domain.Entities;

import java.util.HashMap;

public class TourUserID {

    String userID;

    private TourUserID(){}

    public TourUserID(String id){
        this.userID = id;
    }

    public HashMap<String, Object> dataDB(){
        return new HashMap<>(){{
            put("userID", userID);
        }};
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

}