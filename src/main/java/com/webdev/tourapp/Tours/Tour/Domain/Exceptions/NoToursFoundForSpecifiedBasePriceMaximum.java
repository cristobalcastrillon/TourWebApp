package com.webdev.tourapp.Tours.Tour.Domain.Exceptions;

public class NoToursFoundForSpecifiedBasePriceMaximum extends RuntimeException {
    public NoToursFoundForSpecifiedBasePriceMaximum(String message){
        super(message);
    }
}
