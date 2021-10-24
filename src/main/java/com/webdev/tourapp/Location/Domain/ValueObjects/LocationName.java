package com.webdev.tourapp.Location.Domain.ValueObjects;

import com.webdev.tourapp.Shared.Domain.Aggregate.StringValueObject;

public class LocationName extends StringValueObject {

    private LocationName(){}

    public LocationName(String name){
        this.validate(name);
        this.value = name;
    }

    private void validate(String name) {

    }

}