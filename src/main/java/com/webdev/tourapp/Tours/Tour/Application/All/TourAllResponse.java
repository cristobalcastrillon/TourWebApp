package com.webdev.tourapp.Tours.Tour.Application.All;

import com.webdev.tourapp.Tours.Tour.Domain.Tour;

import java.util.List;

public class TourAllResponse {

    private List<Tour> tours;

    public TourAllResponse(List<Tour> tours){
        this.tours = tours;
    }

    //TODO: Develop reponse() method
}
