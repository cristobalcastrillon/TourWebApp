package com.webdev.tourapp.Tours.Tour.Domain;

import com.webdev.tourapp.Tours.Tour.Domain.Entities.Location;
import com.webdev.tourapp.Tours.Tour.Domain.ValueObjects.TourID;
import com.webdev.tourapp.Tours.Tour.Domain.ValueObjects.TourName;
import com.webdev.tourapp.Tours.Tour.Domain.ValueObjects.TourPrice;

import java.util.List;

public class Tour {
    private TourID tourID;
    private TourName tourName;
    private TourPrice tourPrice;
    private List<Location> locationsIncludedInTour;

    private Tour(){}

    public Tour(TourID id,
                TourName name,
                TourPrice price,
                List<Location> locationsInTour){
        this.tourID = id;
        this.tourName = name;
        this.tourPrice = price;
        this.locationsIncludedInTour = locationsInTour;
    }

    public static Tour Create(TourID id,
                              TourName name,
                              TourPrice price,
                              List<Location> locationsInTour){

        Tour tour = new Tour(id, name, price, locationsInTour);
        // EVENTS
        return tour;
    }
}