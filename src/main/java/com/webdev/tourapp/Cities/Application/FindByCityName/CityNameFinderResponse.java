package com.webdev.tourapp.Cities.Application.FindByCityName;

import com.webdev.tourapp.Cities.Domain.City;

public class CityNameFinderResponse {
    private City city;

    public CityNameFinderResponse(City city) {
        this.city = city;
    }


    //Pendiente metodo response()

//    public HashMap response() {
//        HashMap response = city.stream().map(t -> t.data()).collect(Collectors.toList());
//        response.stream().forEach(h -> h.remove("cityName"));
//        return response;
//    }
}
