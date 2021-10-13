package com.webdev.tourapp.Tours.Tour.Domain;

import com.webdev.tourapp.Tours.Tour.Domain.ValueObjects.TourID;
import com.webdev.tourapp.Tours.Tour.Domain.ValueObjects.TourName;
import com.webdev.tourapp.Tours.Tour.Domain.ValueObjects.TourPrice;

public class Tour {
    private TourID tourID;
    private TourName tourName;
    private TourPrice tourPrice;

    private Tour(){}

    public Tour(TourID id,
                TourName name,
                TourPrice price){
        this.tourID = id;
        this.tourName = name;
        this.tourPrice = price;
    }

    public static Tour Create(TourID id,
                              TourName name,
                              TourPrice price){

        Tour tour = new Tour(id, name, price);
        // EVENTS
        return tour;
    }
}