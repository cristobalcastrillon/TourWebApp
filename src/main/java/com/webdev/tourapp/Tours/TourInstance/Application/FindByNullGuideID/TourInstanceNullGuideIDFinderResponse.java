package com.webdev.tourapp.Tours.TourInstance.Application.FindByNullGuideID;

import com.webdev.tourapp.Tours.TourInstance.Domain.TourInstance;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class TourInstanceNullGuideIDFinderResponse {
    private List<TourInstance> tourInstances;

    public TourInstanceNullGuideIDFinderResponse(List<TourInstance> tourInstances){
        this.tourInstances = tourInstances;
    }

    public List<HashMap<String, Object>> response() {
        List<HashMap<String, Object>> response = tourInstances.stream().map(element -> element.data()).collect(Collectors.toList());
        return response;
    }
}
