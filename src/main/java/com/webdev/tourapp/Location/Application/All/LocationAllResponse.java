package com.webdev.tourapp.Location.Application.All;

import com.webdev.tourapp.Location.Domain.Location;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class LocationAllResponse {
    private List<Location> locations;

    public LocationAllResponse(List<Location> locations) {
        this.locations = locations;
    }

    public List<HashMap<String, Object>> response() {
        List<HashMap<String, Object>> response = locations.stream().map(element -> element.data()).collect(Collectors.toList());
        return response;
    }

}