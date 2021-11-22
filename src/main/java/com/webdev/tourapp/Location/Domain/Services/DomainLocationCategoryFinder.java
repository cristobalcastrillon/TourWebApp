package com.webdev.tourapp.Location.Domain.Services;

import com.webdev.tourapp.Location.Domain.Exceptions.NoLocationsFoundForCategoryException;
import com.webdev.tourapp.Location.Domain.Location;
import com.webdev.tourapp.Location.Domain.Ports.LocationRepository;
import com.webdev.tourapp.Location.Domain.ValueObjects.LocationCategory;

import java.util.List;
import java.util.Optional;

public class DomainLocationCategoryFinder {
    private LocationRepository repository;

    public DomainLocationCategoryFinder(LocationRepository repository) {
        this.repository = repository;
    }

    public List<Location> execute(String category) {
        Optional<List<Location>> locationListOptional = repository.findByCategory(new LocationCategory(category));

        if(locationListOptional.isEmpty()) {
            throw new NoLocationsFoundForCategoryException("No locations found for category: " + category);
        }
        return locationListOptional.get();
    }
}