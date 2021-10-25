package com.webdev.tourapp.Tours.TourInstance.Application.All;


import com.webdev.tourapp.Tours.TourInstance.Domain.TourInstance;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class TourInstanceAllResponse {
    private List<TourInstance> tourInstances;

    public TourInstanceAllResponse(List<TourInstance> tourInstances){
        this.tourInstances = tourInstances;
    }

    public List<HashMap<String, Object>> response() {
        List<HashMap<String, Object>> response = tourInstances.stream().map(element -> element.data()).collect(Collectors.toList());
        return response;
    }
}
