package com.webdev.tourapp.Tours.TourInstance.Domain.Exceptions;

public class NoToursFoundForSpecifiedNumberOfPersons extends RuntimeException {
    public NoToursFoundForSpecifiedNumberOfPersons(String message) {
        super(message);
    }
}
