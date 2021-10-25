package com.webdev.tourapp.Location.Domain.ValueObjects;

import com.webdev.tourapp.Shared.Domain.Aggregate.StringValueObject;

public class LocationCoordinates extends StringValueObject {
    private LocationCoordinates() {}

    public LocationCoordinates(String coordinates){
        validate(coordinates);
        this.value = coordinates;
    }

    private void validate(String coordinates) {
        
    }
}