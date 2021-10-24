package com.webdev.tourapp.Tours.Tour.Domain.ValueObjects;

import com.webdev.tourapp.Shared.Domain.Aggregate.CustomUUID;

public class TourID extends CustomUUID {

    public TourID(String value) {
        super(value);
    }

    public TourID(){}

}