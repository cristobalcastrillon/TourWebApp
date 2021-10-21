package com.webdev.tourapp.Tours.Tour.Domain.Exceptions;

public class NoToursFoundForSpecifiedLocationList extends RuntimeException {
    public NoToursFoundForSpecifiedLocationList(String message) {
        super(message);
    }
}
