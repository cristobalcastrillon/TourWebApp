package com.webdev.tourapp.Cities.Domain.Exeptions;

public class IataLenghtNotValid extends RuntimeException {
    public IataLenghtNotValid(String message) {
        super(message);
    }
}
