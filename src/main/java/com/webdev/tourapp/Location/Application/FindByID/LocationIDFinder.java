package com.webdev.tourapp.Location.Application.FindByID;

import com.webdev.tourapp.Location.Domain.Exceptions.LocationIDNotFoundException;
import com.webdev.tourapp.Location.Domain.Location;
import com.webdev.tourapp.Location.Domain.Ports.LocationRepository;
import com.webdev.tourapp.Location.Domain.Services.DomainLocationIDFinder;
import com.webdev.tourapp.Location.Domain.ValueObjects.LocationID;

import java.util.Optional;

public class LocationIDFinder {

    private LocationRepository repository;
    private DomainLocationIDFinder finderService;

    public LocationIDFinder(LocationRepository repository) {
        this.repository = repository;
        this.finderService = new DomainLocationIDFinder(this.repository);
    }

    public LocationIDFinderResponse execute(String id) {
        Optional<Location> locationOptional = repository.findById(new LocationID(id));

        if (locationOptional.isEmpty()) {
            throw new LocationIDNotFoundException("Location " + id + " not found");
        }

        Location location = locationOptional.get();

        return new LocationIDFinderResponse(location);
    }

}