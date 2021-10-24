package com.webdev.tourapp.Tours.Tour.Domain.Entities;

import java.util.HashMap;

public class Location {

    String locationID;
    String locationName;
    String locationCoordinates;
    String locationDescription;
    String locationCategory;
    String locationWebsiteURL;
    Double locationPrice;

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

    public HashMap<String, Object> dataDB(){
        return new HashMap<>(){{
            put("locationID", locationID);
            put("locationName", locationName);
            put("locationCoordinates", locationCoordinates);
            put("locationDescription", locationDescription);
            put("locationCategory", locationCategory);
            put("locationWebsiteURL", locationWebsiteURL);
            put("locationPrice", locationPrice);
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

    public String getLocationWebsiteURL() {
        return locationWebsiteURL;
    }

    public void setLocationWebsiteURL(String locationWebsiteURL) {
        this.locationWebsiteURL = locationWebsiteURL;
    }

    public Double getLocationPrice() {
        return locationPrice;
    }

    public void setLocationPrice(Double locationPrice) {
        this.locationPrice = locationPrice;
    }
}