package com.webdev.tourapp.Cities.Domain.Exeptions;

public class IdNotValid extends RuntimeException {
    public IdNotValid(String message) {
        super(message);
    }
}
