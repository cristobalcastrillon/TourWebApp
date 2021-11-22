package com.webdev.tourapp.Cities.Domain.Exceptions;

public class NoCityFound extends RuntimeException {
    public NoCityFound(String message) {
        super(message);
    }
}