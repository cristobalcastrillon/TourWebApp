package com.webdev.tourapp.Tours.Tour.Application.All;

import com.webdev.tourapp.Tours.Tour.Domain.Exceptions.NoToursFound;
import com.webdev.tourapp.Tours.Tour.Domain.Ports.TourRepository;
import com.webdev.tourapp.Tours.Tour.Domain.Tour;

import java.util.List;
import java.util.Optional;

public class TourAll {
    TourRepository repository;

    public TourAll(TourRepository repository){
        this.repository = repository;
    }

    public TourAllResponse execute(){
        Optional<List<Tour>> tourListOptional = repository.all();

        if(tourListOptional.isEmpty()){
            throw new NoToursFound("No se ha encontrado ningún tour.");
        }

        List<Tour> tourList = tourListOptional.get();

        return new TourAllResponse(tourList);
    }
}
