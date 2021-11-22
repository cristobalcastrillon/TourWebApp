package com.webdev.tourapp.Cities.Domain.Entities;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class ToursInCity {
    private String cityID;
    private String cityName;
    private String cityIata;
    private Optional<List<LocationsInCity>> locationsInCity;
    private Optional<List<ToursInCity>> toursInCity;

    private ToursInCity() {  }

    public ToursInCity(String cityID, String cityName, String cityIata) {
        this.cityID = cityID;
        this.cityName = cityName;
        this.cityIata = cityIata;
    }

    public String getCityID() {
        return cityID;
    }

    public void setCityID(String cityID) {
        this.cityID = cityID;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityIata() {
        return cityIata;
    }

    public void setCityIata(String cityIata) {
        this.cityIata = cityIata;
    }

    public Optional<List<LocationsInCity>> getLocationsInCity() {
        return locationsInCity;
    }

    public void setLocationsInCity(Optional<List<LocationsInCity>> locationsInCity) {
        this.locationsInCity = locationsInCity;
    }

    public Optional<List<ToursInCity>> getToursInCity() {
        return toursInCity;
    }

    public void setToursInCity(Optional<List<ToursInCity>> toursInCity) {
        this.toursInCity = toursInCity;
    }

    public HashMap<String, Object> dataDB() {
        return new HashMap<>(){{
            put("cityID", cityID);
            put("cityName", cityName);
            put("cityIata", cityIata);
            // Aqui tampoco c xd
        }};
    }
}