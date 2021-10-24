package com.webdev.tourapp.Tours.Tour.Domain.ValueObjects;

import com.webdev.tourapp.Shared.Domain.Aggregate.StringValueObject;
import com.webdev.tourapp.Tours.Tour.Domain.Exceptions.TourNameNotValid;

public class TourName extends StringValueObject {

    public TourName(){

    }

    public TourName(String tourName) {
        validate(tourName);
        this.value = tourName;
    }

    private void validate(String tourName) {
        tourNameLength(tourName);
    }

    private void tourNameLength(String tourName) {
        int length = tourName.length();
        if (length > 100) {
            throw new TourNameNotValid("¡El nombre del tour es muy largo!");
        }
    }
}
