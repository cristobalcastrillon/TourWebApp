package com.webdev.tourapp.Cities.Domain.Exceptions;

public class CityNotFound extends RuntimeException {
    public CityNotFound(String message) {
        super(message);
    }
}