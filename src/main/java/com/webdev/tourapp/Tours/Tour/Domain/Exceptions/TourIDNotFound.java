package com.webdev.tourapp.Tours.Tour.Domain.Exceptions;

public class TourIDNotFound extends RuntimeException {
    public TourIDNotFound(String message) {
        super(message);
    }
}
