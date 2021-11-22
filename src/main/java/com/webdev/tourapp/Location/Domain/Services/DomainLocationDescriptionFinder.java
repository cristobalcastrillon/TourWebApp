package com.webdev.tourapp.Location.Domain.Services;

import com.webdev.tourapp.Location.Domain.Exceptions.NoLocationsFoundForDescriptionException;
import com.webdev.tourapp.Location.Domain.Location;
import com.webdev.tourapp.Location.Domain.Ports.LocationRepository;
import com.webdev.tourapp.Location.Domain.ValueObjects.LocationDescription;

import java.util.List;
import java.util.Optional;

public class DomainLocationDescriptionFinder {
    private LocationRepository repository;

    public DomainLocationDescriptionFinder(LocationRepository repository) {
        this.repository = repository;
    }

    public List<Location> execute(String description) {
        Optional<List<Location>> locations = repository.findByDescription(new LocationDescription(description));
        if (locations.isEmpty()) {
            throw new NoLocationsFoundForDescriptionException("No locations found for description: " + description);
        }
        return locations.get();
    }


}