package com.webdev.tourapp.Location.Domain.Exceptions;

public class NoLocationsFoundCoordinatesException extends RuntimeException{
    public NoLocationsFoundCoordinatesException(String message) {
        super(message);
    }
}