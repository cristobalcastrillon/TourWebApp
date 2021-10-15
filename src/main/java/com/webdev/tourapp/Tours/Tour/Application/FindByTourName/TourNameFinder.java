package com.webdev.tourapp.Tours.Tour.Application.FindByTourName;

import com.webdev.tourapp.Tours.Tour.Domain.Ports.TourRepository;
import com.webdev.tourapp.Tours.Tour.Domain.Services.DomainTourNameFinder;
import com.webdev.tourapp.Tours.Tour.Domain.Tour;
import com.webdev.tourapp.Tours.Tour.Domain.ValueObjects.TourName;
import org.apache.el.stream.Optional;

import java.util.ArrayList;

public class TourNameFinder {
    private TourRepository repository;
    private DomainTourNameFinder finderService;

    public TourNameFinder(TourRepository repository){
        this.repository = repository;
        this.finderService = new DomainTourNameFinder(this.repository);
    }

    public ArrayList<Tour> execute(String name){
        return finderService.execute(name);
    }

}
