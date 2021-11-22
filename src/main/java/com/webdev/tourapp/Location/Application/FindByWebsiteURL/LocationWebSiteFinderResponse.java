package com.webdev.tourapp.Location.Application.FindByWebsiteURL;

import com.webdev.tourapp.Location.Domain.Location;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class LocationWebSiteFinderResponse {
    private List<Location> locationList;

    public LocationWebSiteFinderResponse(List<Location> locationList) {
        this.locationList = locationList;
    }

    public List<HashMap<String, Object>> response() {
        List<HashMap<String, Object>> response = locationList.stream().map(element -> element.data()).collect(Collectors.toList());
        return response;
    }


}