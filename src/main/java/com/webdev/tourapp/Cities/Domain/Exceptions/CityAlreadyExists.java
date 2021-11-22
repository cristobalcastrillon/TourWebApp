package com.webdev.tourapp.Cities.Domain.Exceptions;

public class CityAlreadyExists extends RuntimeException{
    public CityAlreadyExists(String message){
        super(message);
    }
}
