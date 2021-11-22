package com.webdev.tourapp.Location.Domain.Services;

import com.webdev.tourapp.Location.Domain.Exceptions.NoLocationsFoundCoordinatesException;
import com.webdev.tourapp.Location.Domain.Location;
import com.webdev.tourapp.Location.Domain.Ports.LocationRepository;
import com.webdev.tourapp.Location.Domain.ValueObjects.LocationCoordinates;

import java.util.List;
import java.util.Optional;

public class DomainLocationCoordinatesFinder {
    private LocationRepository repository;

    public DomainLocationCoordinatesFinder(LocationRepository repository) {
        this.repository = repository;
    }

    public List<Location> execute(String coordinates){
        Optional<List<Location>> locationList = repository.findByCoordinates(new LocationCoordinates(coordinates));

        if(locationList.isEmpty()){
            throw new NoLocationsFoundCoordinatesException("No locations found for coordinates: " + coordinates);
        }
        return locationList.get();
    }

}