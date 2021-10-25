package com.webdev.tourapp.Tours.TourInstance.Domain.ValueObjects;

import com.webdev.tourapp.Shared.Domain.Aggregate.CustomUUID;

public class AssociatedTourID extends CustomUUID {

    public AssociatedTourID(){}

    public AssociatedTourID(String id){
        super(id);
    }
}
