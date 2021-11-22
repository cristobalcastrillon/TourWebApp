package com.webdev.tourapp.Location.Application.FindByID;

import com.webdev.tourapp.Location.Domain.Location;

import java.util.HashMap;

public class LocationIDFinderResponse {

    private Location location;

    public LocationIDFinderResponse(Location location){
        this.location = location;
    }

    public HashMap response(){
        HashMap<String,Object> response = new HashMap<>();
        response.put("location", location.data());
        return response;
    }
}