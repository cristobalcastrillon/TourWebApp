package com.webdev.tourapp.Tours.TourInstance.Application.FindByNullGuideID;

import com.webdev.tourapp.Tours.TourInstance.Domain.Ports.TourInstanceRepository;
import com.webdev.tourapp.Tours.TourInstance.Domain.Services.DomainTourInstanceNullGuideIDFinder;
import com.webdev.tourapp.Tours.TourInstance.Domain.TourInstance;

import java.util.List;
import java.util.Optional;

public class TourInstanceNullGuideIDFinder {
    private TourInstanceRepository repository;
    private DomainTourInstanceNullGuideIDFinder finderService;

    public TourInstanceNullGuideIDFinder(TourInstanceRepository repository){
        this.repository = repository;
        finderService = new DomainTourInstanceNullGuideIDFinder(this.repository);
    }

    public TourInstanceNullGuideIDFinderResponse execute(){
        List<TourInstance> tourInstances = finderService.execute();
        return new TourInstanceNullGuideIDFinderResponse(tourInstances);
    }

}
