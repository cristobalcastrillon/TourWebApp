package com.webdev.tourapp.Tours.TourInstance.Domain.Exceptions;

public class NotValidState extends RuntimeException {
    public NotValidState(String message) {
        super(message);
    }
}
