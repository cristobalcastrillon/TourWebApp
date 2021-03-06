package com.webdev.tourapp.Tours.Tour.Domain.Services;

import com.webdev.tourapp.Tours.Tour.Domain.Entities.Location;
import com.webdev.tourapp.Tours.Tour.Domain.Exceptions.NoToursFoundForSpecifiedLocationList;
import com.webdev.tourapp.Tours.Tour.Domain.Ports.TourRepository;
import com.webdev.tourapp.Tours.Tour.Domain.Tour;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DomainTourLocationListFinder {

    TourRepository repository;

    public DomainTourLocationListFinder(TourRepository repository){
        this.repository = repository;
    }

    public List<Tour> execute(Optional<List<Location>> minLocationList){

        Optional<List<Tour>> tourList = repository.findByListOfLocations(minLocationList);

        if(tourList.isEmpty()){
            throw new NoToursFoundForSpecifiedLocationList("No se ha encontrado ningún tour que contenga las ubicaciones especificadas.");
        }

        return tourList.get();
    }
}
