package com.webdev.tourapp.Tours.TourInstance.Domain;

import com.webdev.tourapp.Tours.TourInstance.Domain.Entities.StartingLocation;
import com.webdev.tourapp.Tours.TourInstance.Domain.Entities.TourGuide;
import com.webdev.tourapp.Tours.TourInstance.Domain.Entities.TourUser;
import com.webdev.tourapp.Tours.TourInstance.Domain.Entities.TransportCompanyHired;
import com.webdev.tourapp.Tours.TourInstance.Domain.ValueObjects.*;

import java.util.List;
import java.util.Optional;

public class TourInstance {
    TourDate tourDate;
    TourInstanceID tourInstanceID;
    TourNumberOfPersons tourNumberOfPersons;
    TourTotalPrice tourTotalPrice;
    TourInstanceStatus tourInstanceStatus;
    TourGuide tourGuide;
    StartingLocation startingLocation;
    Optional<List<TourUser>> tourUsers;
    Optional<TransportCompanyHired> transportCompanyHired;
    AssociatedTourID associatedTourID;

    public TourInstance(){}

    public TourInstance(TourDate date,
                        TourInstanceID instanceID,
                        TourNumberOfPersons numberOfPersons,
                        TourTotalPrice totalPrice,
                        TourInstanceStatus status,
                        TourGuide guide,
                        StartingLocation sLocation,
                        Optional<List<TourUser>> users,
                        Optional<TransportCompanyHired> companyHired,
                        AssociatedTourID associatedTourID){
        this.tourDate = date;
        this.tourInstanceID = instanceID;
        this.tourNumberOfPersons = numberOfPersons;
        this.tourTotalPrice = totalPrice;
        this.tourInstanceStatus = status;
        this.tourGuide = guide;
        this.startingLocation = sLocation;
        this.tourUsers = users;
        this.transportCompanyHired = companyHired;
        this.associatedTourID = associatedTourID;
    }

    public static TourInstance Create(TourDate date,
                                      TourInstanceID instanceID,
                                      TourNumberOfPersons numberOfPersons,
                                      TourTotalPrice totalPrice,
                                      TourInstanceStatus status,
                                      TourGuide guide,
                                      StartingLocation sLocation,
                                      Optional<List<TourUser>> users,
                                      Optional<TransportCompanyHired> companyHired,
                                      AssociatedTourID associatedTourID){

        TourInstance tourInstance = new TourInstance(date, instanceID, numberOfPersons, totalPrice, status, guide, sLocation, users, companyHired, associatedTourID);
        //EVENTS
        return tourInstance;
    }
}