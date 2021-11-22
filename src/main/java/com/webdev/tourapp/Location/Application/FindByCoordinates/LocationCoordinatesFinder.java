package com.webdev.tourapp.Location.Application.FindByCoordinates;

import com.webdev.tourapp.Location.Domain.Exceptions.NoLocationsFoundCoordinatesException;
import com.webdev.tourapp.Location.Domain.Location;
import com.webdev.tourapp.Location.Domain.Ports.LocationRepository;
import com.webdev.tourapp.Location.Domain.Services.DomainLocationCoordinatesFinder;
import com.webdev.tourapp.Location.Domain.ValueObjects.LocationCoordinates;

import java.util.List;
import java.util.Optional;

public class LocationCoordinatesFinder {
    private LocationRepository repository;
    private DomainLocationCoordinatesFinder finderService;

    public LocationCoordinatesFinder(LocationRepository repository) {
        this.repository = repository;
        this.finderService = new DomainLocationCoordinatesFinder(this.repository);
    }

    public LocationCoordinatesFinderResponse execute(String coordinates) {
        Optional<List<Location>> locations = repository.findByCoordinates(new LocationCoordinates(coordinates));

        if(locations.isEmpty()) {
            throw new NoLocationsFoundCoordinatesException("No locations found for coordinates: " + coordinates);
        }

        List<Location> locationList = locations.get();
        return new LocationCoordinatesFinderResponse(locationList);
    }
}