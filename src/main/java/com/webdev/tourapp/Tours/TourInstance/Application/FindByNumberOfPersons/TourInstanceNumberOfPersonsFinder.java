package com.webdev.tourapp.Tours.TourInstance.Application.FindByNumberOfPersons;

import com.webdev.tourapp.Tours.TourInstance.Domain.Ports.TourInstanceRepository;
import com.webdev.tourapp.Tours.TourInstance.Domain.Services.DomainTourInstanceNumberOfPersonsFinder;
import com.webdev.tourapp.Tours.TourInstance.Domain.TourInstance;

import java.util.ArrayList;

public class TourInstanceNumberOfPersonsFinder {
    private TourInstanceRepository repository;
    private DomainTourInstanceNumberOfPersonsFinder finderService;

    public TourInstanceNumberOfPersonsFinder(TourInstanceRepository repository){
        this.repository = repository;
        finderService = new DomainTourInstanceNumberOfPersonsFinder(this.repository);
    }

    public ArrayList<TourInstance> execute(Integer numberOfPersons){
        return finderService.execute(numberOfPersons);
    }
}
