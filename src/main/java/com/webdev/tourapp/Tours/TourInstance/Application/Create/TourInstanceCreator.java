package com.webdev.tourapp.Tours.TourInstance.Application.Create;

import com.webdev.tourapp.Tours.TourInstance.Domain.Entities.StartingLocation;
import com.webdev.tourapp.Tours.TourInstance.Domain.Entities.TourGuide;
import com.webdev.tourapp.Tours.TourInstance.Domain.Entities.TourUser;
import com.webdev.tourapp.Tours.TourInstance.Domain.Entities.TransportCompanyHired;
import com.webdev.tourapp.Tours.TourInstance.Domain.Exceptions.TourInstanceAlreadyExists;
import com.webdev.tourapp.Tours.TourInstance.Domain.Ports.TourInstanceRepository;
import com.webdev.tourapp.Tours.TourInstance.Domain.TourInstance;
import com.webdev.tourapp.Tours.TourInstance.Domain.ValueObjects.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class TourInstanceCreator{

    private TourInstanceRepository repository;

    public TourInstanceCreator(TourInstanceRepository repository){
        this.repository = repository;
    }

    public void execute(Date tourDate,
                        String id,
                        Integer numberOfPersons,
                        Double totalPrice,
                        String status,
                        TourGuide guide,
                        StartingLocation startingLocation,
                        Optional<List<TourUser>> usersInTour,
                        Optional<TransportCompanyHired> companyHired){
        this.validate(id);
        TourInstance tourInstance = TourInstance.Create(new TourDate(tourDate),
                new TourInstanceID(id),
                new TourNumberOfPersons(numberOfPersons),
                new TourTotalPrice(totalPrice),
                new TourInstanceStatus(status),
                guide,
                startingLocation,
                usersInTour,
                companyHired);
        repository.save(tourInstance);
    }

    private void validate(String tourID){
        Optional<TourInstance> tour = repository.findByID(new TourInstanceID(tourID));
        if(tour.isPresent()){
            throw new TourInstanceAlreadyExists("El tour con id " + tourID + " ya existe.");
        }
    }
}