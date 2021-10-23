package com.webdev.tourapp.Tours.Tour.Domain.Services;

import com.webdev.tourapp.Tours.Tour.Domain.Exceptions.NoToursFoundForSpecifiedTourName;
import com.webdev.tourapp.Tours.Tour.Domain.Ports.TourRepository;
import com.webdev.tourapp.Tours.Tour.Domain.Tour;
import com.webdev.tourapp.Tours.Tour.Domain.ValueObjects.TourName;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DomainTourNameFinder {
    private TourRepository repository;

    public DomainTourNameFinder(TourRepository repository){
        this.repository = repository;
    }

    public List<Tour> execute(String name){
        //TODO: ¿Debería findByTourName permitir regex (e.g. query: "Gaudí", response: "Tour Gaudí en Barcelona", "Tour Gaudí"...)?
        Optional<List<Tour>> tourListOptional = repository.findByTourName(new TourName(name));

        if(tourListOptional.isEmpty()){
            throw new NoToursFoundForSpecifiedTourName("No se ha encontrado ningún tour con el nombre especificado.");
        }

        return tourListOptional.get();
    }
}
