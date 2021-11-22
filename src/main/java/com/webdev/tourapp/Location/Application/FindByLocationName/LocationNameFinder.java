package com.webdev.tourapp.Location.Application.FindByLocationName;

import com.webdev.tourapp.Location.Domain.Exceptions.NoLocationFoundForSpecifiedLocationName;
import com.webdev.tourapp.Location.Domain.Location;
import com.webdev.tourapp.Location.Domain.Ports.LocationRepository;
import com.webdev.tourapp.Location.Domain.Services.DomainLocationNameFinder;
import com.webdev.tourapp.Location.Domain.ValueObjects.LocationName;

import java.util.List;
import java.util.Optional;

public class LocationNameFinder {

    private LocationRepository repository;
    private DomainLocationNameFinder domainFinder;

    public LocationNameFinder(LocationRepository repository) {
        this.repository = repository;
        domainFinder = new DomainLocationNameFinder(repository);
    }

    public LocationNameFinderResponse execute(String name){
        Optional<List<Location>> locationListOptional = repository.findByName(new LocationName(name));

        if (locationListOptional.isEmpty()) {
            throw new NoLocationFoundForSpecifiedLocationName("No locations found");
        }

        List<Location> locationList = locationListOptional.get();

        return new LocationNameFinderResponse(locationList);
    }
}