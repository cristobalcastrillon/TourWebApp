
package com.webdev.tourapp.Location.Domain.Exceptions;

public class LocationIDNotFoundException extends RuntimeException{
    public LocationIDNotFoundException(String message) {
        super(message);
    }
}