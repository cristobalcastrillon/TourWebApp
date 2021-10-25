package com.webdev.tourapp.Cities.Domain.Exceptions;

public class NumberInNameNoValid extends RuntimeException {
    public NumberInNameNoValid(String message) {
        super(message);
    }
}
