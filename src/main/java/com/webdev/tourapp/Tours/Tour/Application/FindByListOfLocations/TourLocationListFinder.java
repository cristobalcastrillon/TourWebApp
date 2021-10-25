package com.webdev.tourapp.Tours.Tour.Application.FindByListOfLocations;

import com.webdev.tourapp.Tours.Tour.Domain.Entities.Location;
import com.webdev.tourapp.Tours.Tour.Domain.Ports.TourRepository;
import com.webdev.tourapp.Tours.Tour.Domain.Services.DomainTourLocationListFinder;
import com.webdev.tourapp.Tours.Tour.Domain.Tour;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*
 * Este caso de uso busca los tours cuyo listado de ubicaciones contiene * al menos * las ubicaciones especificadas
 */

public class TourLocationListFinder {

    TourRepository repository;
    DomainTourLocationListFinder finderService;

    public TourLocationListFinder(TourRepository repository){
        this.repository = repository;
        finderService = new DomainTourLocationListFinder(this.repository);
    }

    public List<Tour> execute(Optional<List<Location>> minLocationList){ return finderService.execute(minLocationList); }

}
