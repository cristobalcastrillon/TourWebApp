package com.webdev.tourapp.Tours.TourInstance.Application.FindByDate;

import com.webdev.tourapp.Tours.TourInstance.Domain.Ports.TourInstanceRepository;
import com.webdev.tourapp.Tours.TourInstance.Domain.Services.DomainTourInstanceDateFinder;
import com.webdev.tourapp.Tours.TourInstance.Domain.TourInstance;

import java.util.ArrayList;
import java.util.Date;

public class TourInstanceDateFinder {
    private TourInstanceRepository repository;
    private DomainTourInstanceDateFinder finderService;

    public TourInstanceDateFinder(TourInstanceRepository repository){
        this.repository = repository;
        finderService = new DomainTourInstanceDateFinder(this.repository);
    }

    public ArrayList<TourInstance> execute(Date date){
        return finderService.execute(date);
    }
}
