package com.webdev.tourapp.Tours.TourInstance.Domain;

import com.webdev.tourapp.Tours.TourInstance.Domain.ValueObjects.*;

public class TourInstance {
    TourDate tourDate;
    TourInstanceID tourInstanceID;
    TourNumberOfPersons tourNumberOfPersons;
    TourTotalPrice tourTotalPrice;
    TourInstanceStatus tourInstanceStatus;

    private TourInstance(){}

    public TourInstance(TourDate date,
                        TourInstanceID instanceID,
                        TourNumberOfPersons numberOfPersons,
                        TourTotalPrice totalPrice,
                        TourInstanceStatus status){
        this.tourDate = date;
        this.tourInstanceID = instanceID;
        this.tourNumberOfPersons = numberOfPersons;
        this.tourTotalPrice = totalPrice;
        this.tourInstanceStatus = status;
    }

    public TourInstance Create(TourDate date,
                               TourInstanceID instanceID,
                               TourNumberOfPersons numberOfPersons,
                               TourTotalPrice totalPrice,
                               TourInstanceStatus status){
        TourInstance tourInstance = new TourInstance(date, instanceID, numberOfPersons, totalPrice, status);
        //EVENTS
        return tourInstance;
    }
}