package com.webdev.tourapp.Location.Domain.Exceptions;

public class LocationAlreadyExists extends RuntimeException{
    public LocationAlreadyExists(String message) {
        super(message);
    }
}