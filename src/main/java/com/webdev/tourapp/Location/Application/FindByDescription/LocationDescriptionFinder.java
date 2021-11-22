package com.webdev.tourapp.Location.Application.FindByDescription;

import com.webdev.tourapp.Location.Domain.Exceptions.NoLocationsFoundForDescriptionException;
import com.webdev.tourapp.Location.Domain.Location;
import com.webdev.tourapp.Location.Domain.Ports.LocationRepository;
import com.webdev.tourapp.Location.Domain.Services.DomainLocationDescriptionFinder;
import com.webdev.tourapp.Location.Domain.ValueObjects.LocationDescription;

import java.util.List;
import java.util.Optional;

public class LocationDescriptionFinder {
    private LocationRepository repository;
    private DomainLocationDescriptionFinder finderService;

    public LocationDescriptionFinder(LocationRepository repository){
        this.repository = repository;
        finderService = new DomainLocationDescriptionFinder(this.repository);
    }

    public LocationDescriptionFinderResponse execute(String description){
        Optional<List<Location>> locations = repository.findByDescription(new LocationDescription(description));
        if(locations.isEmpty()){
            throw new NoLocationsFoundForDescriptionException("No locations found for description: " + description);
        }

        List<Location> locationList = locations.get();
        return new LocationDescriptionFinderResponse(locationList);
    }


}