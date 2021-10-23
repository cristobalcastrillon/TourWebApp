package com.webdev.tourapp.Cities.Application.FinderByID;

import com.webdev.tourapp.Cities.Domain.City;

import java.util.HashMap;

public class CityIDFinderResponse {

    private City city;

    public CityIDFinderResponse(City city) {
        this.city = city;
    }

    public HashMap response(){
        HashMap data = city.data();
        data.remove(/*Aqui no se xd*/"idCity");
        return data;
    }

}
