package com.webdev.tourapp.Tours.Tour.Domain.Exceptions;

public class TourAlreadyExists extends RuntimeException {
    public TourAlreadyExists(String message) {
        super(message);
    }
}
