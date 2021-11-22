package com.webdev.tourapp.Location.Domain.Exceptions;

public class NoLocationsFoundForLocationWebSiteURL extends RuntimeException{
    public NoLocationsFoundForLocationWebSiteURL(String message){
        super(message);
    }
}