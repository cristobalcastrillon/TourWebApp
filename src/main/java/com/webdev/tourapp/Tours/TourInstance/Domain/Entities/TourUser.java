package com.webdev.tourapp.Tours.TourInstance.Domain.Entities;

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
}