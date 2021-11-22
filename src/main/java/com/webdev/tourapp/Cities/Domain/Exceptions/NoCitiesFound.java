package com.webdev.tourapp.Cities.Domain.Exceptions;

public class NoCitiesFound extends RuntimeException{
    public NoCitiesFound(String message) {
        super(message);
    }
}