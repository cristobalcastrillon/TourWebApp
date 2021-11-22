package com.webdev.tourapp.Cities.Application.All;

import com.webdev.tourapp.Cities.Domain.City;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class CityAllResponse {
    private List<City> cities;

    public CityAllResponse(List<City> cities){
        this.cities = cities;
    }

    public List<HashMap<String, Object>> response() {
        List<HashMap<String, Object>> response = cities.stream().map(element -> element.data()).collect(Collectors.toList());
        return response;
    }

}

// Completado
// Pendiente para revisar