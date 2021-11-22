package com.webdev.tourapp.Location.Domain.Ports;

import com.webdev.tourapp.Location.Domain.Location;
import com.webdev.tourapp.Location.Domain.ValueObjects.*;

import java.util.List;
import java.util.Optional;

public interface LocationRepository {
    void save(Location location);
    void update(Location location);
    void delete(Location location);

    Optional<Location> findById(LocationID id);
    Optional<List<Location>> findByName(LocationName name);
    Optional<List<Location>> findByCoordinates(LocationCoordinates coordinates);
    Optional<List<Location>> findByDescription(LocationDescription description);
    Optional<List<Location>> findByWebsiteURL(LocationWebsiteURL websiteURL);
    Optional<List<Location>> findByCategory(LocationCategory category);
    Optional<List<Location>> findByPrice(LocationPrice price);
    Optional<List<Location>> all();

}