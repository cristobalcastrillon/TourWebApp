package com.webdev.tourapp.Tours.Tour.Application.FindByTourName;

import com.webdev.tourapp.Tours.Tour.Domain.Tour;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class TourNameFinderResponse {
    private List<Tour> tourList;

    public TourNameFinderResponse(List<Tour> tourList){
        this.tourList = tourList;
    }

    public List<HashMap<String, Object>> response() {
        List<HashMap<String, Object>> response = tourList.stream().map(element -> element.data()).collect(Collectors.toList());
        return response;
    }
}
