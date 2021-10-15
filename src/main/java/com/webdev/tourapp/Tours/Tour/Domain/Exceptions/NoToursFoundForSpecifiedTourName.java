package com.webdev.tourapp.Tours.Tour.Domain.Exceptions;

public class NoToursFoundForSpecifiedTourName extends RuntimeException {
    public NoToursFoundForSpecifiedTourName(String message) {
        super(message);
    }
}
