package com.webdev.tourapp.Location.Domain.ValueObjects;

import com.webdev.tourapp.Shared.Domain.Aggregate.StringValueObject;

public class LocationDescription extends StringValueObject {
    private LocationDescription() { }

    public LocationDescription(String description){
        validate(description);
        this.value = description;
    }

    private void validate(String description) {
    }

}