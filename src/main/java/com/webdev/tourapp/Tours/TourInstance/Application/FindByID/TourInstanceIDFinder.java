package com.webdev.tourapp.Tours.TourInstance.Application.FindByID;

import com.webdev.tourapp.Tours.TourInstance.Domain.Exceptions.TourInstanceIDNotFound;
import com.webdev.tourapp.Tours.TourInstance.Domain.Ports.TourInstanceRepository;
import com.webdev.tourapp.Tours.TourInstance.Domain.Services.DomainTourInstanceIDFinder;
import com.webdev.tourapp.Tours.TourInstance.Domain.TourInstance;
import com.webdev.tourapp.Tours.TourInstance.Domain.ValueObjects.TourInstanceID;

import java.util.Optional;

public class TourInstanceIDFinder {

    private TourInstanceRepository repository;
    private DomainTourInstanceIDFinder finderService;

    public TourInstanceIDFinder(TourInstanceRepository repository){
        this.repository = repository;
        finderService = new DomainTourInstanceIDFinder(this.repository);
    }

    public TourInstanceIDFinderResponse execute(String id){
        Optional<TourInstance> tourInstanceOptional = repository.findByID(new TourInstanceID(id));

        if(tourInstanceOptional.isEmpty()){
            throw new TourInstanceIDNotFound("No existe ninguna instancia de tour con el id " + id);
        }

        TourInstance tourInstance = tourInstanceOptional.get();

        return new TourInstanceIDFinderResponse(tourInstance);
    }
}
