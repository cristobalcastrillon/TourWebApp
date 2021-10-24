package com.webdev.tourapp.Tours.Tour.Application.FindByBasePriceMaximum;

import com.webdev.tourapp.Tours.Tour.Domain.Ports.TourRepository;
import com.webdev.tourapp.Tours.Tour.Domain.Services.DomainTourBasePriceMaximumFinder;
import com.webdev.tourapp.Tours.Tour.Domain.Tour;

import java.util.ArrayList;
import java.util.List;

/*
* Este caso de uso busca los tours cuyo precio base es * menor o igual * al especificado (maxBasePrice)
*/

public class TourBasePriceMaximumFinder {

    private TourRepository repository;
    private DomainTourBasePriceMaximumFinder finderService;

    public TourBasePriceMaximumFinder(TourRepository repository){
        this.repository = repository;
        finderService = new DomainTourBasePriceMaximumFinder(this.repository);
    }

    public List<Tour> execute(Double maxBasePrice){
        return finderService.execute(maxBasePrice);
    }
}
