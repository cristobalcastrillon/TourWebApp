package com.webdev.tourapp.Tours.Tour.Application.FindByID;

import com.webdev.tourapp.Tours.Tour.Domain.Ports.TourRepository;
import com.webdev.tourapp.Tours.Tour.Domain.Services.DomainTourIDFinder;
import com.webdev.tourapp.Tours.Tour.Domain.Tour;

public class TourIDFinder {

    private TourRepository repository;
    private DomainTourIDFinder finderService;

    public TourIDFinder(TourRepository repository){
        this.repository = repository;
        finderService = new DomainTourIDFinder(this.repository);
    }

    public Tour execute(String id){
        return finderService.execute(id);
    }
}
