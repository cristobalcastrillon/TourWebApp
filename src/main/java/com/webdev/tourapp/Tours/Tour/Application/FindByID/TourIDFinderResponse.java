package com.webdev.tourapp.Tours.Tour.Application.FindByID;

import com.webdev.tourapp.Tours.Tour.Domain.Tour;

import java.util.HashMap;

public class TourIDFinderResponse {
    private Tour tourResponse;

    public TourIDFinderResponse(Tour tourResponse){
        this.tourResponse = tourResponse;
    }

    public HashMap<String, Object> response() {
        HashMap<String, Object> response = new HashMap<>();
        response.put("tour", tourResponse.data());
        return response;
    }
}
