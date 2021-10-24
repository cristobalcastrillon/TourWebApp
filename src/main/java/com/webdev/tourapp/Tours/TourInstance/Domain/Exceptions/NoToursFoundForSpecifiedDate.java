package com.webdev.tourapp.Tours.TourInstance.Domain.Exceptions;

public class NoToursFoundForSpecifiedDate extends RuntimeException {
    public NoToursFoundForSpecifiedDate(String message) {
        super(message);
    }
}
