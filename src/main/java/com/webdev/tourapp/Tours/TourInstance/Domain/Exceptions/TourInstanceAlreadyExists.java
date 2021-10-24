package com.webdev.tourapp.Tours.TourInstance.Domain.Exceptions;

public class TourInstanceAlreadyExists extends RuntimeException {
    public TourInstanceAlreadyExists(String message) {
        super(message);
    }
}
