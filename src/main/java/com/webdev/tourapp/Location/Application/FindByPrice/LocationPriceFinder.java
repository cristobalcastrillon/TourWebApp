package com.webdev.tourapp.Location.Application.FindByPrice;

import com.webdev.tourapp.Location.Domain.Exceptions.NoLocationsFoundForLocationsPrice;
import com.webdev.tourapp.Location.Domain.Location;
import com.webdev.tourapp.Location.Domain.Ports.LocationRepository;
import com.webdev.tourapp.Location.Domain.Services.DomainLocationPriceFinder;
import com.webdev.tourapp.Location.Domain.ValueObjects.LocationPrice;

import java.util.List;
import java.util.Optional;

public class LocationPriceFinder {
    private LocationRepository repository;
    private DomainLocationPriceFinder finderService;

    public LocationPriceFinder(LocationRepository repository) {
        this.repository = repository;
        this.finderService = new DomainLocationPriceFinder(repository);
    }

    public LocationPriceFinderResponse execute(double price) {
        Optional<List<Location>> locationListOptional = repository.findByPrice(new LocationPrice(price));
        if (locationListOptional.isEmpty()) {
            throw new NoLocationsFoundForLocationsPrice("No locations found for price: " + price);
        }
        List<Location> locationList = locationListOptional.get();
        return new LocationPriceFinderResponse(locationList);
    }

}