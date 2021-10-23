package com.webdev.tourapp.Cities.Application.FindByDefaultIATA;

import com.webdev.tourapp.Cities.Domain.City;

import java.util.HashMap;

public class CityDefaultIATAFinderResponse {
    private City city;

    public CityDefaultIATAFinderResponse(City city) {
        this.city = city;
    }

    public HashMap response(){
        HashMap data = city.data();
        data.remove(/*Aqui no se xd*/"iataCity");
        return data;
    }
}
// Completado
// Pendiente de revision
