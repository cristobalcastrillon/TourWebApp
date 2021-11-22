package com.webdev.tourapp.Location.Domain.Services;

import com.webdev.tourapp.Location.Domain.Exceptions.LocationIDNotFoundException;
import com.webdev.tourapp.Location.Domain.Location;
import com.webdev.tourapp.Location.Domain.Ports.LocationRepository;
import com.webdev.tourapp.Location.Domain.ValueObjects.LocationID;

import java.util.Optional;

public class DomainLocationIDFinder {

    private LocationRepository repository;

    public DomainLocationIDFinder(LocationRepository repository) {
        this.repository = repository;
    }

    public Location execute(String id) {
        Optional<Location> locationOptional = repository.findById(new LocationID(id));

        if (locationOptional.isEmpty()) {
            throw new LocationIDNotFoundException("Location " + id + " not found");
        }
        return locationOptional.get();
    }
}