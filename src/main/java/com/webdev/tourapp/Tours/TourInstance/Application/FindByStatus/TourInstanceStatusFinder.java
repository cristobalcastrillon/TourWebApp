package com.webdev.tourapp.Tours.TourInstance.Application.FindByStatus;

import com.webdev.tourapp.Tours.TourInstance.Domain.Ports.TourInstanceRepository;
import com.webdev.tourapp.Tours.TourInstance.Domain.Services.DomainTourInstanceStatusFinder;
import com.webdev.tourapp.Tours.TourInstance.Domain.TourInstance;

import java.util.List;

public class TourInstanceStatusFinder {
    private TourInstanceRepository repository;
    private DomainTourInstanceStatusFinder finderService;

    public TourInstanceStatusFinder(TourInstanceRepository repository){
        this.repository = repository;
        finderService = new DomainTourInstanceStatusFinder(this.repository);
    }

    public List<TourInstance> execute(String status){
        return finderService.execute(status);
    }

}
