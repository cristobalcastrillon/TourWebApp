package com.webdev.tourapp.Tours.TourInstance.Application.All;


import com.webdev.tourapp.Tours.TourInstance.Domain.TourInstance;

import java.util.List;

public class TourInstanceAllResponse {
    private List<TourInstance> tourInstances;

    public TourInstanceAllResponse(List<TourInstance> tourInstances){
        this.tourInstances = tourInstances;
    }

    //TODO: Develop reponse() method
}
