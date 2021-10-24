package com.webdev.tourapp.Tours.TourInstance.Domain.Services;

import com.webdev.tourapp.Tours.TourInstance.Domain.Exceptions.NoToursFoundForSpecifiedTotalPrice;
import com.webdev.tourapp.Tours.TourInstance.Domain.Ports.TourInstanceRepository;
import com.webdev.tourapp.Tours.TourInstance.Domain.TourInstance;
import com.webdev.tourapp.Tours.TourInstance.Domain.ValueObjects.TourTotalPrice;

import java.util.List;
import java.util.Optional;

public class DomainTourInstanceTotalPriceFinder {
    TourInstanceRepository repository;

    public DomainTourInstanceTotalPriceFinder(TourInstanceRepository repository) {
        this.repository = repository;
    }

    public List<TourInstance> execute(Double totalPrice){
        Optional<List<TourInstance>> tourInstanceListOptional = repository.findByTotalPrice(new TourTotalPrice(totalPrice));

        if(tourInstanceListOptional.isEmpty()){
            throw new NoToursFoundForSpecifiedTotalPrice("No existen tours para el precio máximo especificado.");
        }

        return tourInstanceListOptional.get();
    }
}
