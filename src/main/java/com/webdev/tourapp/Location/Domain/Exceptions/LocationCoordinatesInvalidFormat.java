package com.webdev.tourapp.Location.Domain.Exceptions;

public class LocationCoordinatesInvalidFormat extends RuntimeException{
    public LocationCoordinatesInvalidFormat(String message) {
        super(message);
    }
}