package com.webdev.tourapp.Tours.Tour.Domain.Exceptions;

public class NoToursFound extends RuntimeException {
    public NoToursFound(String message) {
        super(message);
    }
}
