package com.webdev.tourapp.Tours.TourInstance.Domain.Entities;

import java.util.HashMap;
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

    public HashMap<String, Object> dataDB(){
        return new HashMap<>(){{
            put("locationID", locationID);
            put("locationName", locationName);
            put("locationCoordinates", locationCoordinates);
            put("locationDescription", locationDescription);
            put("locationCategory", locationCategory);
            put("locationWebsiteURL", locationWebsiteURL.get());
            put("locationPrice", locationPrice.get());
        }};
    }

    public String getLocationID() {
        return locationID;
    }

    public void setLocationID(String locationID) {
        this.locationID = locationID;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getLocationCoordinates() {
        return locationCoordinates;
    }

    public void setLocationCoordinates(String locationCoordinates) {
        this.locationCoordinates = locationCoordinates;
    }

    public String getLocationDescription() {
        return locationDescription;
    }

    public void setLocationDescription(String locationDescription) {
        this.locationDescription = locationDescription;
    }

    public String getLocationCategory() {
        return locationCategory;
    }

    public void setLocationCategory(String locationCategory) {
        this.locationCategory = locationCategory;
    }

    public Optional<String> getLocationWebsiteURL() {
        return locationWebsiteURL;
    }

    public void setLocationWebsiteURL(Optional<String> locationWebsiteURL) {
        this.locationWebsiteURL = locationWebsiteURL;
    }

    public Optional<Double> getLocationPrice() {
        return locationPrice;
    }

    public void setLocationPrice(Optional<Double> locationPrice) {
        this.locationPrice = locationPrice;
    }
}