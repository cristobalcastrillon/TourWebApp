package com.webdev.tourapp.Tours.Tour.Domain.Exceptions;

public class NotValidTourPrice extends RuntimeException {
    public NotValidTourPrice(String message) {
        super(message);
    }
}
