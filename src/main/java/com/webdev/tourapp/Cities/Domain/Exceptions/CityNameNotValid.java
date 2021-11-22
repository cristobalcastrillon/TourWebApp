package com.webdev.tourapp.Cities.Domain.Exceptions;

public class CityNameNotValid extends RuntimeException {
    public CityNameNotValid(String message) {
        super(message);
    }
}