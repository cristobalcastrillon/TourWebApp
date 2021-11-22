package com.webdev.tourapp.Cities.Domain.Exceptions;

public class CityDefaultIATANotFound extends RuntimeException{
    public CityDefaultIATANotFound(String cityID){
        super(cityID);
    }
}