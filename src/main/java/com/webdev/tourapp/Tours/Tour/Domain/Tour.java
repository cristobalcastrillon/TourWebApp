package com.webdev.tourapp.Tours.Tour.Domain;

import com.webdev.tourapp.Tours.Tour.Domain.Entities.Location;
import com.webdev.tourapp.Tours.Tour.Domain.ValueObjects.TourID;
import com.webdev.tourapp.Tours.Tour.Domain.ValueObjects.TourName;
import com.webdev.tourapp.Tours.Tour.Domain.ValueObjects.TourPrice;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

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

    public HashMap<String, Object> data() {
        HashMap<String, Object> data = new HashMap<>(){{
            put("id", tourID.value());
            put("name", tourName.value());
            put("price", tourPrice.value());
            put("locationsIncludedInTour", locationsIncludedInTour);
        }};
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tour tour = (Tour) o;
        return tourID.equals(tour.tourID) && tourName.equals(tour.tourName) && Objects.equals(tourPrice, tour.tourPrice) && locationsIncludedInTour.equals(tour.locationsIncludedInTour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tourID, tourName, tourPrice, locationsIncludedInTour);
    }
}