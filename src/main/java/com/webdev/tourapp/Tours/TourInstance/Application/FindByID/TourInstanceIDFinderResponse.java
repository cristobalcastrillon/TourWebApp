package com.webdev.tourapp.Tours.TourInstance.Application.FindByID;

import com.webdev.tourapp.Tours.TourInstance.Domain.TourInstance;

import java.util.HashMap;

public class TourInstanceIDFinderResponse {
    private TourInstance tourInstance;

    public TourInstanceIDFinderResponse(TourInstance tourInstance){
        this.tourInstance = tourInstance;
    }

    public HashMap<String, Object> response() {
        HashMap<String, Object> response = new HashMap<>();
        response.put("tourInstance", tourInstance.data());
        return response;
    }

}
