package com.webdev.tourapp.Tours.Tour.Application.All;

import com.webdev.tourapp.Tours.Tour.Domain.Tour;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class TourAllResponse {

    private List<Tour> tours;

    public TourAllResponse(List<Tour> tours){
        this.tours = tours;
    }

    public List<HashMap<String, Object>> response() {
        List<HashMap<String, Object>> response = tours.stream().map(element -> element.data()).collect(Collectors.toList());
        return response;
    }
}
