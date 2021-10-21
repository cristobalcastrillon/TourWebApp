package com.webdev.tourapp.Tours.TourInstance.Domain.Entities;

import java.util.Optional;

public class StartingLocation {

    String locationID;
    String locationName;
    String locationCoordinates;
    String locationDescription;
    String locationCategory;
    Optional<String> locationWebsiteURL;
    Optional<Double> locationPrice;

    private StartingLocation(){}

    public StartingLocation(String id,
                            String name,
                            String coordinates,
                            String description,
                            String category,
                            Optional<String> websiteURL,
                            Optional<Double> price){
        this.locationID = id;
        this.locationName = name;
        this.locationCoordinates = coordinates;
        this.locationDescription = description;
        this.locationCategory = category;
        this.locationWebsiteURL = websiteURL;
        this.locationPrice = price;
    }
}