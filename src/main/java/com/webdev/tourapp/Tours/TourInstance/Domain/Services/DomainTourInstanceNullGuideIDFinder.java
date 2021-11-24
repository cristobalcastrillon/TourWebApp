package com.webdev.tourapp.Tours.TourInstance.Domain.Services;

import com.webdev.tourapp.Tours.TourInstance.Domain.Exceptions.NoToursFoundForSpecifiedStatus;
import com.webdev.tourapp.Tours.TourInstance.Domain.Ports.TourInstanceRepository;
import com.webdev.tourapp.Tours.TourInstance.Domain.TourInstance;

import java.util.List;
import java.util.Optional;

public class DomainTourInstanceNullGuideIDFinder {
    private TourInstanceRepository repository;

    public DomainTourInstanceNullGuideIDFinder(TourInstanceRepository repository) {
        this.repository = repository;
    }

    public List<TourInstance> execute(){
        Optional<List<TourInstance>> tourInstanceListOptional = repository.findByNullGuideID();

        if(tourInstanceListOptional.isEmpty()){
            throw new NoToursFoundForSpecifiedStatus("No hay ningún tour disponible...");
        }

        return tourInstanceListOptional.get();
    }
}
