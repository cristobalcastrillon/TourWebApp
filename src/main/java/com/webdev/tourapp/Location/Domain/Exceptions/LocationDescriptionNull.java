package com.webdev.tourapp.Location.Domain.Exceptions;

public class LocationDescriptionNull extends RuntimeException{
    public LocationDescriptionNull(String message){
        super(message);
    }
}