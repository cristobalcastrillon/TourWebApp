package com.webdev.tourapp.Tours.Tour.Application.Update;

import com.webdev.tourapp.Tours.Tour.Domain.Entities.Location;
import com.webdev.tourapp.Tours.Tour.Domain.Exceptions.TourIDNotFound;
import com.webdev.tourapp.Tours.Tour.Domain.Ports.TourRepository;
import com.webdev.tourapp.Tours.Tour.Domain.Tour;
import com.webdev.tourapp.Tours.Tour.Domain.ValueObjects.TourID;
import com.webdev.tourapp.Tours.Tour.Domain.ValueObjects.TourName;
import com.webdev.tourapp.Tours.Tour.Domain.ValueObjects.TourPrice;

import java.util.List;
import java.util.Optional;

public class TourUpdater {
    private TourRepository repository;

    public TourUpdater(TourRepository repository){
        this.repository = repository;
    }

    public void execute(String id,
                        String name,
                        Double price,
                        Optional<List<Location>> locationsInTour){
        this.validate(id);
        Tour tour = Tour.Create(new TourID(id), new TourName(name), new TourPrice(price), locationsInTour);
        repository.update(tour);
    }

    private void validate(String tourID){
        Optional<Tour> tour = repository.findByID(new TourID(tourID));
        if(tour.isEmpty()){
            throw new TourIDNotFound("El tour con id " + tourID + ", que desea modificar, no ha sido encontrado.");
        }
    }
}
