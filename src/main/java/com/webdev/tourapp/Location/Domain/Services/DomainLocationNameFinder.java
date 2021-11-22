package com.webdev.tourapp.Location.Domain.Services;

import com.webdev.tourapp.Location.Domain.Exceptions.NoLocationFoundForSpecifiedLocationName;
import com.webdev.tourapp.Location.Domain.Location;
import com.webdev.tourapp.Location.Domain.Ports.LocationRepository;
import com.webdev.tourapp.Location.Domain.ValueObjects.LocationName;

import java.util.List;
import java.util.Optional;

public class DomainLocationNameFinder {
    private LocationRepository repository;

    public DomainLocationNameFinder(LocationRepository repository) {
        this.repository = repository;
    }

    public List<Location> execute(String name) {
        Optional<List<Location>> locationListOptional = repository.findByName(new LocationName(name));

        if (locationListOptional.isEmpty()) {
            throw new NoLocationFoundForSpecifiedLocationName("No location found for specified location name");
        }
        return locationListOptional.get();
    }
}