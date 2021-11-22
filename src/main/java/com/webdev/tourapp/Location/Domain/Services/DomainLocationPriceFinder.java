package com.webdev.tourapp.Location.Domain.Services;

import com.webdev.tourapp.Location.Domain.Exceptions.NoLocationsFoundForLocationsPrice;
import com.webdev.tourapp.Location.Domain.Location;
import com.webdev.tourapp.Location.Domain.Ports.LocationRepository;
import com.webdev.tourapp.Location.Domain.ValueObjects.LocationPrice;

import java.util.List;
import java.util.Optional;

public class DomainLocationPriceFinder {
    private LocationRepository repository;

    public DomainLocationPriceFinder(LocationRepository repository) {
        this.repository = repository;
    }

    public List<Location> execute(double price) {
        Optional<List<Location>> locationListOptional = repository.findByPrice(new LocationPrice(price));
        if (locationListOptional.isEmpty()) {
            throw new NoLocationsFoundForLocationsPrice("No locations found for price: " + price);
        }
        return locationListOptional.get();
    }
}