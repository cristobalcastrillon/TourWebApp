package com.webdev.tourapp.Location.Domain.ValueObjects;

import com.webdev.tourapp.Shared.Domain.Aggregate.StringValueObject;

public class LocationCategory extends StringValueObject {
    public LocationCategory(String category) {
        validate(category);
        this.value = category;
    }

    private LocationCategory() {
    }

    private void validate(String category) {
    }
}