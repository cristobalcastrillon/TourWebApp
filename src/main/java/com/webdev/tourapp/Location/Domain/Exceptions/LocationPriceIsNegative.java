package com.webdev.tourapp.Location.Domain.Exceptions;

public class LocationPriceIsNegative extends RuntimeException{
    public LocationPriceIsNegative(String message){
        super(message);
    }
}