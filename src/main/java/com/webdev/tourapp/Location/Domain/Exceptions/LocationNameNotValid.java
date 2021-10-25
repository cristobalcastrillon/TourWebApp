package com.webdev.tourapp.Location.Domain.Exceptions;

public class LocationNameNotValid extends RuntimeException {
    public LocationNameNotValid(String message) {
        super(message);
    }
}
