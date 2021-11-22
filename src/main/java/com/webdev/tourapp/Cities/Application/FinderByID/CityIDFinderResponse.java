package com.webdev.tourapp.Cities.Application.FinderByID;

import com.webdev.tourapp.Cities.Domain.City;

import java.util.HashMap;

public class CityIDFinderResponse {

    private City city;

    public CityIDFinderResponse(City city) {
        this.city = city;
    }

    public HashMap response(){
        HashMap<String, Object> response = new HashMap<>();
        response.put("city", city.data());
        return response;
    }

}