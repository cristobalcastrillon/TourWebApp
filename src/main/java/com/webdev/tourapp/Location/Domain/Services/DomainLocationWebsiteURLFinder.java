package com.webdev.tourapp.Location.Domain.Services;

import com.webdev.tourapp.Location.Domain.Exceptions.NoLocationsFoundForLocationWebSiteURL;
import com.webdev.tourapp.Location.Domain.Location;
import com.webdev.tourapp.Location.Domain.Ports.LocationRepository;
import com.webdev.tourapp.Location.Domain.ValueObjects.LocationWebsiteURL;

import java.util.List;
import java.util.Optional;

public class DomainLocationWebsiteURLFinder {
    private LocationRepository repository;

    public DomainLocationWebsiteURLFinder(LocationRepository repository) {
        this.repository = repository;
    }

    public List<Location> execute(String url) {
        Optional<List<Location>> locationsListOptional = repository.findByWebsiteURL(new LocationWebsiteURL(url));
        if (locationsListOptional.isEmpty()) {
            throw new NoLocationsFoundForLocationWebSiteURL("No locations found with website URL: " + url);
        }
        return locationsListOptional.get();
    }

}