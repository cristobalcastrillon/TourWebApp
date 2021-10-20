package com.webdev.tourapp.Tours.TourInstance.Domain.Services;

import com.webdev.tourapp.Tours.TourInstance.Domain.Exceptions.NoToursFoundForSpecifiedStatus;
import com.webdev.tourapp.Tours.TourInstance.Domain.Ports.TourInstanceRepository;
import com.webdev.tourapp.Tours.TourInstance.Domain.TourInstance;
import com.webdev.tourapp.Tours.TourInstance.Domain.ValueObjects.TourInstanceStatus;

import java.util.ArrayList;
import java.util.Optional;

public class DomainTourInstanceStatusFinder {
    TourInstanceRepository repository;

    public DomainTourInstanceStatusFinder(TourInstanceRepository repository) {
        this.repository = repository;
    }

    public ArrayList<TourInstance> execute(String status){
        Optional<ArrayList<TourInstance>> tourInstanceListOptional = repository.findByStatus(new TourInstanceStatus(status));

        if(tourInstanceListOptional.isEmpty()){
            throw new NoToursFoundForSpecifiedStatus("No existen tours para la fecha especificada.");
        }

        return tourInstanceListOptional.get();
    }
}
