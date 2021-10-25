package com.webdev.tourapp.Location.Application.Create;

import com.webdev.tourapp.Location.Domain.Location;
import com.webdev.tourapp.Location.Domain.Ports.LocationRepository;
import com.webdev.tourapp.Location.Domain.ValueObjects.*;

public class LocationCreator {
    private LocationRepository repository;
    public LocationCreator(LocationRepository repository){
        this.repository = repository;
    }

    public void execute(
            //String id,
                        String name,
                        String coordinates,
                        String description,
                        String websiteUrl,
                        String category,
                        Double price){

        Location location = Location.Create(
               // new LocationID(id),
                new LocationName(name),
                new LocationCoordinates(coordinates),
                new LocationDescription(description),
                new LocationWebsiteURL(websiteUrl),
                new LocationCategory(category),
                new LocationPrice(price));

        repository.save(location);
    }
}