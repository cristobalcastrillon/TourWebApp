package com.webdev.tourapp.Tours.TourInstance.Domain.Exceptions;

public class NotValidTourTotalPrice extends RuntimeException {
    public NotValidTourTotalPrice(String message) {
        super(message);
    }
}
