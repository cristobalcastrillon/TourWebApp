package com.webdev.tourapp.Tours.Tour.Application.All;

import com.webdev.tourapp.Tours.Tour.Domain.Tour;

import java.util.ArrayList;

public class TourAllResponse {

    private ArrayList<Tour> tours;

    public TourAllResponse(ArrayList<Tour> tours){
        this.tours = tours;
    }

    //TODO: Develop reponse() method
}
