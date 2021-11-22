package com.webdev.tourapp.Location.Domain.ValueObjects;

import com.webdev.tourapp.Location.Domain.Exceptions.LocationDescriptionNull;
import com.webdev.tourapp.Shared.Domain.Aggregate.StringValueObject;

public class LocationDescription extends StringValueObject {
    private LocationDescription() { }

    public LocationDescription(String description){
        validate(description);
        this.value = description;
    }

    private void validate(String description) {
        if (description.length() < 1) {
            throw new LocationDescriptionNull("Location description must be at least 1 character long.");
        }
    }
}