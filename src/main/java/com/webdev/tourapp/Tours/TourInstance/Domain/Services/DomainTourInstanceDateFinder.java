package com.webdev.tourapp.Tours.TourInstance.Domain.Services;

import com.webdev.tourapp.Tours.TourInstance.Domain.Exceptions.NoToursFoundForSpecifiedDate;
import com.webdev.tourapp.Tours.TourInstance.Domain.Ports.TourInstanceRepository;
import com.webdev.tourapp.Tours.TourInstance.Domain.TourInstance;
import com.webdev.tourapp.Tours.TourInstance.Domain.ValueObjects.TourDate;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

public class DomainTourInstanceDateFinder {
    TourInstanceRepository repository;

    public DomainTourInstanceDateFinder(TourInstanceRepository repository) {
        this.repository = repository;
    }

    public ArrayList<TourInstance> execute(Date date){
        Optional<ArrayList<TourInstance>> tourInstanceListOptional = repository.findByDate(new TourDate(date));

        if(tourInstanceListOptional.isEmpty()){
            throw new NoToursFoundForSpecifiedDate("No existen tours para la fecha especificada.");
        }

        return tourInstanceListOptional.get();
    }
}
