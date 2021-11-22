package com.webdev.tourapp.Location.Application.All;

import com.webdev.tourapp.Location.Domain.Exceptions.NoLocationsFoundException;
import com.webdev.tourapp.Location.Domain.Location;
import com.webdev.tourapp.Location.Domain.Ports.LocationRepository;

import java.util.List;
import java.util.Optional;

public class LocationAll {
    LocationRepository locationRepository;

    public LocationAll(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public LocationAllResponse execute(){
        Optional<List<Location>>  locationListOptional = locationRepository.all();

        if(locationListOptional.isEmpty()){
            throw new NoLocationsFoundException("No locations found");
        }

        List<Location> locationList = locationListOptional.get();

        return new LocationAllResponse(locationList);
    }
}