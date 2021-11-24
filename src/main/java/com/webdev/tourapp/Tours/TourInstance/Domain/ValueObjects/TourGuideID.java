package com.webdev.tourapp.Tours.TourInstance.Domain.ValueObjects;

import com.webdev.tourapp.Shared.Domain.Aggregate.CustomUUID;

public class TourGuideID extends CustomUUID {
    
    public TourGuideID(String value) {
        super(value);
    }

    public TourGuideID() {
    }
}
