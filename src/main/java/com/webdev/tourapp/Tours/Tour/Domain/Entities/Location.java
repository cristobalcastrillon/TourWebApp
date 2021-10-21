package com.webdev.tourapp.Tours.Tour.Domain.Entities;

import java.util.Optional;

public class Location {

    String locationID;
    String locationName;
    String locationCoordinates;
    String locationDescription;
    String locationCategory;
    String locationWebsiteURL;
    Double locationPrice;

    //TODO: ¿El acceso debería ser público? (Lo puse así para poder crear Locations desde los tests).
    public Location(String id,
            String name,
            String coordinates,
            String description,
            String category,
            String websiteURL,
            Double price){
        this.locationID = id;
        this.locationName = name;
        this.locationCoordinates = coordinates;
        this.locationDescription = description;
        this.locationCategory = category;
        this.locationWebsiteURL = websiteURL;
        this.locationPrice = price;
    }

    private Location(){}
}