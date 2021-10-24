package com.webdev.tourapp.Tours.TourInstance.Domain.ValueObjects;

import com.webdev.tourapp.Shared.Domain.Aggregate.CustomUUID;

public class TourInstanceID extends CustomUUID {

    public TourInstanceID(String value) {
        super(value);
    }

    public TourInstanceID(){}

}