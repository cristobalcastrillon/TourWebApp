package com.webdev.tourapp.Location.Domain.Exceptions;

public class NoLocationsFoundException extends RuntimeException {
    public NoLocationsFoundException(String message) {
        super(message);
    }
}