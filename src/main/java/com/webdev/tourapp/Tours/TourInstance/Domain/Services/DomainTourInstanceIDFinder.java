package com.webdev.tourapp.Tours.TourInstance.Domain.Services;

import com.webdev.tourapp.Tours.TourInstance.Domain.Exceptions.TourInstanceIDNotFound;
import com.webdev.tourapp.Tours.TourInstance.Domain.Ports.TourInstanceRepository;
import com.webdev.tourapp.Tours.TourInstance.Domain.TourInstance;
import com.webdev.tourapp.Tours.TourInstance.Domain.ValueObjects.TourInstanceID;

import java.util.Optional;

public class DomainTourInstanceIDFinder {
    private TourInstanceRepository repository;

    public DomainTourInstanceIDFinder(TourInstanceRepository repository){
        this.repository = repository;
    }

    public TourInstance execute(String id){
        Optional<TourInstance> tourInstanceOptional = repository.findByID(new TourInstanceID(id));

        if(tourInstanceOptional.isEmpty()){
            throw new TourInstanceIDNotFound("El tour con id " + id + " no ha sido encontrado." );
        }

        return tourInstanceOptional.get();
    }
}
