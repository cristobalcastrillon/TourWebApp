package com.webdev.tourapp.Tours.TourInstance.Domain.Exceptions;

public class NoToursFoundForSpecifiedTotalPrice extends RuntimeException {
    public NoToursFoundForSpecifiedTotalPrice(String message) {
        super(message);
    }
}
