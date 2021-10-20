package com.webdev.tourapp.Tours.TourInstance.Application.All;


import com.webdev.tourapp.Tours.TourInstance.Domain.TourInstance;

import java.util.ArrayList;

public class TourInstanceAllResponse {
    private ArrayList<TourInstance> tourInstances;

    public TourInstanceAllResponse(ArrayList<TourInstance> tourInstances){
        this.tourInstances = tourInstances;
    }

    //TODO: Develop reponse() method
}
