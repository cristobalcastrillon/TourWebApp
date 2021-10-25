package com.webdev.tourapp.Location.Domain.Ports;

import com.webdev.tourapp.Location.Domain.Location;

import java.util.Optional;

public interface LocationRepository {
    void save(Location location);
    Optional<Location> find(Location id);
}