package com.webdev.tourapp.Tours.TourInstance.Application.FindByID;

import com.webdev.tourapp.Tours.TourInstance.Domain.Ports.TourInstanceRepository;
import com.webdev.tourapp.Tours.TourInstance.Domain.Services.DomainTourInstanceIDFinder;
import com.webdev.tourapp.Tours.TourInstance.Domain.TourInstance;

public class TourInstanceIDFinder {

    private TourInstanceRepository repository;
    private DomainTourInstanceIDFinder finderService;

    public TourInstanceIDFinder(TourInstanceRepository repository){
        this.repository = repository;
        finderService = new DomainTourInstanceIDFinder(this.repository);
    }

    public TourInstance execute(String id){
        return finderService.execute(id);
    }
}
