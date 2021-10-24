package com.webdev.tourapp.Tours.Tour.Domain.Services;

import com.webdev.tourapp.Tours.Tour.Domain.Exceptions.TourIDNotFound;
import com.webdev.tourapp.Tours.Tour.Domain.Ports.TourRepository;
import com.webdev.tourapp.Tours.Tour.Domain.Tour;
import com.webdev.tourapp.Tours.Tour.Domain.ValueObjects.TourID;

import java.util.Optional;

public class DomainTourIDFinder {

    private TourRepository repository;

    public DomainTourIDFinder(TourRepository repository){
        this.repository = repository;
    }

    public Tour execute(String id){
        Optional<Tour> tourOptional = repository.findByID(new TourID(id));

        if(tourOptional.isEmpty()){
            throw new TourIDNotFound("El tour con id " + id + " no ha sido encontrado." );
        }

        return tourOptional.get();
    }
}
