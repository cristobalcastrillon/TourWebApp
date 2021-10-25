package com.webdev.tourapp.Tours.Tour.Application.FindByID;

import com.webdev.tourapp.Tours.Tour.Domain.Exceptions.TourIDNotFound;
import com.webdev.tourapp.Tours.Tour.Domain.Ports.TourRepository;
import com.webdev.tourapp.Tours.Tour.Domain.Services.DomainTourIDFinder;
import com.webdev.tourapp.Tours.Tour.Domain.Tour;
import com.webdev.tourapp.Tours.Tour.Domain.ValueObjects.TourID;

import java.util.Optional;

public class TourIDFinder {

    private TourRepository repository;
    private DomainTourIDFinder finderService;

    public TourIDFinder(TourRepository repository){
        this.repository = repository;
        finderService = new DomainTourIDFinder(this.repository);
    }

    public TourIDFinderResponse execute(String id){
        Optional<Tour> tourOptional = repository.findByID(new TourID(id));

        if(tourOptional.isEmpty()){
            throw new TourIDNotFound("No se ha encontrado ningún tour con el id " + id);
        }

        Tour tour = tourOptional.get();

        return new TourIDFinderResponse(tour);
    }
}
