package com.webdev.tourapp.Cities.Application.FindByCityName;

import com.webdev.tourapp.Cities.Domain.City;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class CityNameFinderResponse {
    private List<City> cityList;

    public CityNameFinderResponse(List<City> cityList) {
        this.cityList = cityList;
    }

    public List<HashMap<String,Object>> response() {
        List<HashMap<String, Object>> response = cityList.stream().map(element -> element.data()).collect(Collectors.toList());
        return response;
    }
}

//Completado