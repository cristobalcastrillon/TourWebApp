package com.webdev.tourapp.Cities.Domain.Exceptions;

public class CityNameNotFound extends RuntimeException{

    public CityNameNotFound(String message){
        super(message);
    }
}