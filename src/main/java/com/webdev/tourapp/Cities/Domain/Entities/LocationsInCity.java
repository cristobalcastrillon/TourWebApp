package com.webdev.tourapp.Cities.Domain.Entities;

import java.util.HashMap;

public class LocationsInCity {
    private String locationID;
    private String locationName;
    private String locationCoordinates;
    private String locationDescription;
    private String locationWebsiteURL;
    private String locationCategory;
    private Double locationPrice;

    private LocationsInCity() {  }

    public LocationsInCity(String locationID,String locationName, String locationCoordinates, String locationDescription, String locationWebsiteURL, String locationCategory, Double locationPrice) {
        this.locationID = locationID;
        this.locationName = locationName;
        this.locationCoordinates = locationCoordinates;
        this.locationDescription = locationDescription;
        this.locationWebsiteURL = locationWebsiteURL;
        this.locationCategory = locationCategory;
        this.locationPrice = locationPrice;
    }

    public HashMap<String, Object> dataDB() {
        return new HashMap<>(){{
            put("locationID", locationID);
            put("locationName", locationName);
            put("locationCoordinates", locationCoordinates);
            put("locationDescription", locationDescription);
            put("locationWebsiteURL", locationWebsiteURL);
            put("locationCategory", locationCategory);
            put("locationPrice", locationPrice);
        }};
    }

    public String getLocationID() {
        return locationID;
    }

    public String getLocationName() {
        return locationName;
    }

    public String getLocationCoordinates() {
        return locationCoordinates;
    }

    public String getLocationDescription() {
        return locationDescription;
    }

    public String getLocationWebsiteURL() {
        return locationWebsiteURL;
    }

    public String getLocationCategory() {
        return locationCategory;
    }

    public Double getLocationPrice() {
        return locationPrice;
    }

    public void setLocationID(String locationID) {
        this.locationID = locationID;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public void setLocationCoordinates(String locationCoordinates) {
        this.locationCoordinates = locationCoordinates;
    }

    public void setLocationDescription(String locationDescription) {
        this.locationDescription = locationDescription;
    }

    public void setLocationWebsiteURL(String locationWebsiteURL) {
        this.locationWebsiteURL = locationWebsiteURL;
    }

    public void setLocationCategory(String locationCategory) {
        this.locationCategory = locationCategory;
    }

    public void setLocationPrice(Double locationPrice) {
        this.locationPrice = locationPrice;
    }
}