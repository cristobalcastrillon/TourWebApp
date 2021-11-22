package com.webdev.tourapp.Location.Application.Delete;

import com.webdev.tourapp.Location.Domain.Exceptions.LocationAlreadyExists;
import com.webdev.tourapp.Location.Domain.Exceptions.LocationIDNotFoundException;
import com.webdev.tourapp.Location.Domain.Location;
import com.webdev.tourapp.Location.Domain.Ports.LocationRepository;
import com.webdev.tourapp.Location.Domain.ValueObjects.LocationID;

import java.util.Optional;

public class LocationDeleter {
    private LocationRepository locationRepository;

    public LocationDeleter(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public void deleter(String locationId) {
        Optional<Location> location = this.validate(locationId);
        this.locationRepository.delete(location.get());
    }

    private Optional<Location> validate(String locationId) {

        Optional<Location> location = this.locationRepository.findById(new LocationID(locationId));
        if (!location.isPresent()) {
            throw new LocationIDNotFoundException("Location does not exist");
        }
        return location;
    }

}