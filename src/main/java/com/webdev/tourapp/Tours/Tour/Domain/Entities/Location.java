package com.webdev.tourapp.Tours.Tour.Domain.Entities;

import java.util.Optional;

public class Location {

    String locationID;
    String locationName;
    String locationCoordinates;
    String locationDescription;
    String locationCategory;
    Optional<String> locationWebsiteURL;
    Optional<Double> locationPrice;

    private Location(String id,
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

    public Location(){}
}