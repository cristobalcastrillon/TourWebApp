package com.webdev.tourapp.Tours.TourInstance.Application.FindByTotalPrice;

import com.webdev.tourapp.Tours.TourInstance.Domain.Ports.TourInstanceRepository;
import com.webdev.tourapp.Tours.TourInstance.Domain.Services.DomainTourInstanceTotalPriceFinder;
import com.webdev.tourapp.Tours.TourInstance.Domain.TourInstance;

import java.util.ArrayList;
import java.util.List;

public class TourInstanceTotalPriceFinder {
    private TourInstanceRepository repository;
    private DomainTourInstanceTotalPriceFinder finderService;

    public TourInstanceTotalPriceFinder(TourInstanceRepository repository){
        this.repository = repository;
        finderService = new DomainTourInstanceTotalPriceFinder(this.repository);
    }

    public List<TourInstance> execute(Double totalPrice){
        return finderService.execute(totalPrice);
    }
}
