package com.webdev.tourapp.Location.Domain;

import com.webdev.tourapp.Location.Domain.ValueObjects.*;

import java.util.Objects;

public class Location {
    private LocationID locationid;
    private LocationName locationName;
    private LocationCoordinates locationCoordinates;
    private LocationDescription locationDescription;
    private LocationWebsiteURL locationWebsiteURL;
    private LocationCategory locationCategory;
    private LocationPrice locationPrice;


    public Location(
            //LocationID locationid,
                    LocationName locationName,
                    LocationCoordinates locationCoordinates,
                    LocationDescription locationDescription,
                    LocationWebsiteURL locationWebsiteURL,
                    LocationCategory locationCategory,
                    LocationPrice locationPrice) {
        this.locationid = locationid;
        this.locationName = locationName;
        this.locationCoordinates = locationCoordinates;
        this.locationDescription = locationDescription;
        this.locationWebsiteURL = locationWebsiteURL;
        this.locationCategory = locationCategory;
        this.locationPrice = locationPrice;
    }

    public static Location Create(
                               //   LocationID locationid,
                                  LocationName locationName,
                                  LocationCoordinates locationCoordinates,
                                  LocationDescription locationDescription,
                                  LocationWebsiteURL locationWebsiteURL,
                                  LocationCategory locationCategory,
                                  LocationPrice locationPrice){

        Location location = new Location(
                //locationid,
                locationName,
                locationCoordinates,
                locationDescription,
                locationWebsiteURL,
                locationCategory,
                locationPrice);

        return location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(locationid, location.locationid) && Objects.equals(locationName, location.locationName) && Objects.equals(locationCoordinates, location.locationCoordinates) && Objects.equals(locationDescription, location.locationDescription) && Objects.equals(locationWebsiteURL, location.locationWebsiteURL) && Objects.equals(locationCategory, location.locationCategory) && Objects.equals(locationPrice, location.locationPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(locationid, locationName, locationCoordinates, locationDescription, locationWebsiteURL, locationCategory, locationPrice);
    }
}