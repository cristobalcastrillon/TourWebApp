package com.webdev.tourapp.Location.Domain.Exceptions;

public class NoLocationFoundForSpecifiedLocationName extends RuntimeException{
    public NoLocationFoundForSpecifiedLocationName(String message){
        super(message);
    }
}