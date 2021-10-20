package com.webdev.tourapp.Tours.TourInstance.Domain.Exceptions;

public class TourInstanceIDNotFound extends RuntimeException {
    public TourInstanceIDNotFound(String message) {
        super(message);
    }
}
