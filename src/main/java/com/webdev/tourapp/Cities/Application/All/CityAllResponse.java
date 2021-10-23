package com.webdev.tourapp.Cities.Application.All;

import com.webdev.tourapp.Cities.Domain.City;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

public class CityAllResponse {
    private ArrayList<City> cities;

    public CityAllResponse(ArrayList<City> cities){
        this.cities = cities;
    }

    //TODO: Pendiente para chequear
    public ArrayList<HashMap<String, Object>> response() {
        ArrayList<HashMap<String, Object>> response = cities.stream().map(element -> element.data()).collect(Collectors.toList());
        return response;
    }

}

// Completado
// Pendiente para revisar
