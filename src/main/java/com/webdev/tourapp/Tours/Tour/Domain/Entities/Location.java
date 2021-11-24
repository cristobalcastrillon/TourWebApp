package com.webdev.tourapp.Tours.Tour.Domain.Entities;

import java.util.HashMap;

public class Location {

    String locationID;

    public Location(String id){
        this.locationID = id;
    }

    private Location(){}

    public HashMap<String, Object> dataDB(){
        return new HashMap<>(){{
            put("locationID", locationID);
        }};
    }

    public String getLocationID() {
        return locationID;
    }

    public void setLocationID(String locationID) {
        this.locationID = locationID;
    }
}