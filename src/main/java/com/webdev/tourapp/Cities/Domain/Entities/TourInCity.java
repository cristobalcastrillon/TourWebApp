package com.webdev.tourapp.Cities.Domain.Entities;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class TourInCity {
    String tourID;
    String tourName;
    Double tourPrice;
    Optional<List<LocationInCity>> locationsIncludedInTour;

    public TourInCity(String tourID,
            String tourName,
            Double tourPrice,
            Optional<List<LocationInCity>> locationsIncludedInTour){
        this.tourID = tourID;
        this.tourName = tourName;
        this.tourPrice = tourPrice;
        this.locationsIncludedInTour = locationsIncludedInTour;
    }

    private TourInCity(){}

    public HashMap<String, Object> dataDB(){
        return new HashMap<>(){{
            put("tourID", tourID);
            put("tourName", tourName);
            put("tourPrice", tourPrice);
            put("locationsIncludedInTour", locationsIncludedInTour);
        }};
    }

    public String getTourID() {
        return tourID;
    }

    public void setTourID(String tourID) {
        this.tourID = tourID;
    }

    public String getTourName() {
        return tourName;
    }

    public void setTourName(String tourName) {
        this.tourName = tourName;
    }

    public Double getTourPrice() {
        return tourPrice;
    }

    public void setTourPrice(Double tourPrice) {
        this.tourPrice = tourPrice;
    }

    public Optional<List<LocationInCity>> getLocationsIncludedInTour() {
        return locationsIncludedInTour;
    }

    public void setLocationsIncludedInTour(Optional<List<LocationInCity>> locationsIncludedInTour) {
        this.locationsIncludedInTour = locationsIncludedInTour;
    }
}