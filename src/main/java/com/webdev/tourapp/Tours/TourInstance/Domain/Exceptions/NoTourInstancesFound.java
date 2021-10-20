package com.webdev.tourapp.Tours.TourInstance.Domain.Exceptions;

public class NoTourInstancesFound extends RuntimeException {
    public NoTourInstancesFound(String message) {
        super(message);
    }
}
