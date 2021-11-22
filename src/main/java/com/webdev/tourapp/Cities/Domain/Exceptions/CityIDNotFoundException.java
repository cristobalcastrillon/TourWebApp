package com.webdev.tourapp.Cities.Domain.Exceptions;

public class CityIDNotFoundException extends RuntimeException{
    public CityIDNotFoundException(String message) {
        super(message);
    }
}