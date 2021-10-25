package com.webdev.tourapp.Tours.TourInstance.Domain.Entities;

import java.util.HashMap;

public class TourUser {

    String userID;
    String username;
    String userFirstName;
    String userLastName;

    private TourUser(){}

    public TourUser(String id, String username, String firstName, String lastName){
        this.userID = id;
        this.username = username;
        this.userFirstName = firstName;
        this.userLastName = lastName;
    }

    public HashMap<String, Object> dataDB(){
        return new HashMap<>(){{
            put("userID", userID);
            put("username", username);
            put("userFirstName", userFirstName);
            put("userLastName", userLastName);
        }};
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }
}