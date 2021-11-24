package com.webdev.tourapp.Tours.TourInstance.Domain.Entities;

import java.util.HashMap;
import java.util.Optional;

public class StartingLocation {

    String locationID;

    private StartingLocation(){}

    public StartingLocation(String id){
        this.locationID = id;
    }

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