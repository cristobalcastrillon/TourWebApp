package com.webdev.tourapp.Location.Domain.Exceptions;

public class NoLocationsFoundForLocationsPrice extends RuntimeException{
    public NoLocationsFoundForLocationsPrice(String message){
        super(message);
    }
}