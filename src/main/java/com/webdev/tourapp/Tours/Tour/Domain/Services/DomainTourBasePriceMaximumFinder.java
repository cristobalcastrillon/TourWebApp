package com.webdev.tourapp.Tours.Tour.Domain.Services;

import com.webdev.tourapp.Tours.Tour.Domain.Exceptions.NoToursFoundForSpecifiedBasePriceMaximum;
import com.webdev.tourapp.Tours.Tour.Domain.Ports.TourRepository;
import com.webdev.tourapp.Tours.Tour.Domain.Tour;
import com.webdev.tourapp.Tours.Tour.Domain.ValueObjects.TourPrice;

import java.util.ArrayList;
import java.util.Optional;

public class DomainTourBasePriceMaximumFinder {

    TourRepository repository;

    public DomainTourBasePriceMaximumFinder(TourRepository repository) {
        this.repository = repository;
    }

    public ArrayList<Tour> execute(Double maxBasePrice){
        Optional<ArrayList<Tour>> tourListOptional = repository.findByBasePriceMaximum(new TourPrice(maxBasePrice));

        if(tourListOptional.isEmpty()){
            throw new NoToursFoundForSpecifiedBasePriceMaximum("No existen tours cuyo precio base sea menor o igual al especificado.");
        }

        return tourListOptional.get();
    }
}
