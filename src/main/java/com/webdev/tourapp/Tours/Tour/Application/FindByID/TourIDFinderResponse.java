package com.webdev.tourapp.Tours.Tour.Application.FindByID;

import com.webdev.tourapp.Tours.Tour.Domain.Tour;

import java.util.HashMap;

public class TourIDFinderResponse {
    private Tour tour;

    public TourIDFinderResponse(Tour tour){
        this.tour = tour;
    }

    public HashMap<String, Object> response() {
        HashMap<String, Object> response = new HashMap<>();
        response.put("tour", tour.data());
        return response;
    }
}
