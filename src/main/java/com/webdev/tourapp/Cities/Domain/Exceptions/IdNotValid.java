package com.webdev.tourapp.Cities.Domain.Exceptions;

public class IdNotValid extends RuntimeException {
    public IdNotValid(String message) {
        super(message);
    }
}