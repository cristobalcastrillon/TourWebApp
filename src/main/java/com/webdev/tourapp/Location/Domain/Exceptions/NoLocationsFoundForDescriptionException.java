package com.webdev.tourapp.Location.Domain.Exceptions;

public class NoLocationsFoundForDescriptionException extends RuntimeException{
    public NoLocationsFoundForDescriptionException(String message){
        super(message);
    }
}