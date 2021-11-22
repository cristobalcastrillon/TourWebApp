package com.webdev.tourapp.Location.Domain.Exceptions;

public class LocationWebSiteIsNotValid extends RuntimeException{
    public LocationWebSiteIsNotValid(String message){
        super(message);
    }
}