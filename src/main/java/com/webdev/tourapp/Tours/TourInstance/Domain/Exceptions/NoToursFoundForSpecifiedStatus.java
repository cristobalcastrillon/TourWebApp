package com.webdev.tourapp.Tours.TourInstance.Domain.Exceptions;

public class NoToursFoundForSpecifiedStatus extends RuntimeException {
    public NoToursFoundForSpecifiedStatus(String message) {
        super(message);
    }
}
