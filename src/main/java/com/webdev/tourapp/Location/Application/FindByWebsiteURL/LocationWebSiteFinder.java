package com.webdev.tourapp.Location.Application.FindByWebsiteURL;

import com.webdev.tourapp.Location.Application.FindByLocationName.LocationNameFinderResponse;
import com.webdev.tourapp.Location.Domain.Exceptions.NoLocationsFoundForLocationWebSiteURL;
import com.webdev.tourapp.Location.Domain.Location;
import com.webdev.tourapp.Location.Domain.Ports.LocationRepository;
import com.webdev.tourapp.Location.Domain.Services.DomainLocationWebsiteURLFinder;
import com.webdev.tourapp.Location.Domain.ValueObjects.LocationWebsiteURL;

import java.util.List;
import java.util.Optional;

public class LocationWebSiteFinder {
    private LocationRepository repository;
    private DomainLocationWebsiteURLFinder finderService;

    public LocationWebSiteFinder(LocationRepository repository) {
        this.repository = repository;
        this.finderService = new DomainLocationWebsiteURLFinder(repository);
    }

    public LocationWebSiteFinderResponse execute(String websiteURL) {
        Optional<List<Location>> locationListOptional = repository.findByWebsiteURL(new LocationWebsiteURL(websiteURL));

        if (locationListOptional.isEmpty()) {
            throw new NoLocationsFoundForLocationWebSiteURL("No locations found for website URL: " + websiteURL);
        }
        List<Location> locationsList = locationListOptional.get();
        return new LocationWebSiteFinderResponse(locationsList);
    }
}