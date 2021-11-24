package com.webdev.tourapp.Tours.TourInstance.Application.Update;

import com.webdev.tourapp.Tours.TourInstance.Domain.Entities.StartingLocation;
import com.webdev.tourapp.Tours.TourInstance.Domain.Entities.TourUserID;
import com.webdev.tourapp.Tours.TourInstance.Domain.Entities.TransportCompanyHired;
import com.webdev.tourapp.Tours.TourInstance.Domain.Exceptions.TourInstanceIDNotFound;
import com.webdev.tourapp.Tours.TourInstance.Domain.Ports.TourInstanceRepository;
import com.webdev.tourapp.Tours.TourInstance.Domain.TourInstance;
import com.webdev.tourapp.Tours.TourInstance.Domain.ValueObjects.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class TourInstanceUpdater {
    private TourInstanceRepository repository;

    public TourInstanceUpdater(TourInstanceRepository repository){
        this.repository = repository;
    }

    public void execute(Date tourDate,
                        String id,
                        Integer numberOfPersons,
                        Double totalPrice,
                        String status,
                        Optional<TourGuideID> guideID,
                        Optional<StartingLocation> startingLocation,
                        Optional<List<TourUserID>> usersInTour,
                        Optional<TransportCompanyHired> companyHired,
                        String associatedTourID){
        this.validate(id);
        TourInstance tourInstance = TourInstance.Create(new TourDate(tourDate),
                new TourInstanceID(id),
                new TourNumberOfPersons(numberOfPersons),
                new TourTotalPrice(totalPrice),
                new TourInstanceStatus(status),
                guideID,
                startingLocation,
                usersInTour,
                companyHired,
                new AssociatedTourID(associatedTourID));
        repository.update(tourInstance);
    }

    private void validate(String tourInstanceID){
        Optional<TourInstance> tourInstance = repository.findByID(new TourInstanceID(tourInstanceID));
        if(tourInstance.isEmpty()){
            throw new TourInstanceIDNotFound("La instancia de tour con id " + tourInstanceID + ", que desea modificar, no ha sido encontrada.");
        }
    }
}
