package com.webdev.tourapp.Location.Application.Update;

import com.webdev.tourapp.Location.Domain.Exceptions.LocationIDNotFoundException;
import com.webdev.tourapp.Location.Domain.Location;
import com.webdev.tourapp.Location.Domain.Ports.LocationRepository;
import com.webdev.tourapp.Location.Domain.ValueObjects.*;

import java.util.Optional;

public class LocationUpdater {
    private LocationRepository repository;

    public LocationUpdater(LocationRepository repository) {
        this.repository = repository;
    }

    public void execute(
            String id,
            String name,
            String coordinates,
            String description,
            String websiteURL,
            String category,
            double price
    ) {
        this.validate(id);
        Location location = Location.Create(new LocationID(id), new LocationName(name), new LocationCoordinates(coordinates), new LocationDescription(description), new LocationWebsiteURL(websiteURL), new LocationCategory(category), new LocationPrice(price));
        repository.update(location);
    }

    private void validate(String locationID) {
        Optional<Location> location = repository.findById(new LocationID(locationID));
        if(location.isEmpty()) {
            throw new LocationIDNotFoundException("Location with ID: " + locationID + " not found");
        }
    }
}