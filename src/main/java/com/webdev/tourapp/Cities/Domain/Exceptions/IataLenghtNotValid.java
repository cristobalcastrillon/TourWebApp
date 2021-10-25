package com.webdev.tourapp.Cities.Domain.Exceptions;

public class IataLenghtNotValid extends RuntimeException {
    public IataLenghtNotValid(String message) {
        super(message);
    }
}
