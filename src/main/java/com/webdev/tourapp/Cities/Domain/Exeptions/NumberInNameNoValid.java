package com.webdev.tourapp.Cities.Domain.Exeptions;

public class NumberInNameNoValid extends RuntimeException {
    public NumberInNameNoValid(String message) {
        super(message);
    }
}
