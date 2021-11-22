package com.webdev.tourapp.Location.Application.FindByCategory;

import com.webdev.tourapp.Location.Domain.Exceptions.NoLocationsFoundForCategoryException;
import com.webdev.tourapp.Location.Domain.Location;
import com.webdev.tourapp.Location.Domain.Ports.LocationRepository;
import com.webdev.tourapp.Location.Domain.Services.DomainLocationCategoryFinder;
import com.webdev.tourapp.Location.Domain.ValueObjects.LocationCategory;

import java.util.List;
import java.util.Optional;

public class LocationCategoryFinder {
    private LocationRepository repository;
    private DomainLocationCategoryFinder finderService;

    public LocationCategoryFinder(LocationRepository repository){
        this.repository = repository;
        this.finderService = new DomainLocationCategoryFinder(this.repository);
    }

    public LocationCategoryFinderResponse execute(String category){
        Optional<List<Location>> locationListOptional = this.repository.findByCategory(new LocationCategory(category));

        if(locationListOptional.isEmpty()){
            throw new NoLocationsFoundForCategoryException("No locations found for category: " + category);
        }

        List<Location> locationList = locationListOptional.get();
        return new LocationCategoryFinderResponse(locationList);
    }

}