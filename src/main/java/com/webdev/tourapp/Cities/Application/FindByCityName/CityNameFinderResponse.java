package com.webdev.tourapp.Cities.Application.FindByCityName;

import com.webdev.tourapp.Cities.Domain.City;

import java.util.HashMap;

public class CityNameFinderResponse {
    private City city;

    public CityNameFinderResponse(City city) {
        this.city = city;
    }

    public HashMap response(){
        HashMap data = city.data();
        data.remove(/*Aqui no se xd*/"nameCity");
        return data;
    }
}

//Completado
//Pendiente revision