package com.webdev.tourapp.Tours.TourInstance.Domain.Exceptions;

public class NotValidNumberOfPersons extends RuntimeException {
    public NotValidNumberOfPersons(String message) {
        super(message);
    }
}
