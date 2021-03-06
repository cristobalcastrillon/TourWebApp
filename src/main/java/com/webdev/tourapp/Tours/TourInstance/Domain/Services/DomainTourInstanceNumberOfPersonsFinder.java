package com.webdev.tourapp.Tours.TourInstance.Domain.Services;

import com.webdev.tourapp.Tours.TourInstance.Domain.Exceptions.NoToursFoundForSpecifiedNumberOfPersons;
import com.webdev.tourapp.Tours.TourInstance.Domain.Ports.TourInstanceRepository;
import com.webdev.tourapp.Tours.TourInstance.Domain.TourInstance;
import com.webdev.tourapp.Tours.TourInstance.Domain.ValueObjects.TourNumberOfPersons;

import java.util.List;
import java.util.Optional;

public class DomainTourInstanceNumberOfPersonsFinder {
    TourInstanceRepository repository;

    public DomainTourInstanceNumberOfPersonsFinder(TourInstanceRepository repository) {
        this.repository = repository;
    }

    public List<TourInstance> execute(Integer numberOfPersons){
        Optional<List<TourInstance>> tourInstanceListOptional = repository.findByNumberOfPersons(new TourNumberOfPersons(numberOfPersons));

        if(tourInstanceListOptional.isEmpty()){
            throw new NoToursFoundForSpecifiedNumberOfPersons("No existen tours para la fecha especificada.");
        }

        return tourInstanceListOptional.get();
    }
}
