package com.webdev.tourapp.Tours.TourInstance.Domain;

import com.webdev.tourapp.Tours.TourInstance.Domain.ValueObjects.TourDate;
import com.webdev.tourapp.Tours.TourInstance.Domain.ValueObjects.TourInstanceID;
import com.webdev.tourapp.Tours.TourInstance.Domain.ValueObjects.TourNumberOfPersons;
import com.webdev.tourapp.Tours.TourInstance.Domain.ValueObjects.TourTotalPrice;

public class TourInstance {
    TourDate tourDate;
    TourInstanceID tourInstanceID;
    TourNumberOfPersons tourNumberOfPersons;
    TourTotalPrice tourTotalPrice;

    private TourInstance(){}

    public TourInstance(TourDate date,
                        TourInstanceID instanceID,
                        TourNumberOfPersons numberOfPersons,
                        TourTotalPrice totalPrice){
        this.tourDate = date;
        this.tourInstanceID = instanceID;
        this.tourNumberOfPersons = numberOfPersons;
        this.tourTotalPrice = totalPrice;
    }

    public TourInstance Create(TourDate date,
                               TourInstanceID instanceID,
                               TourNumberOfPersons numberOfPersons,
                               TourTotalPrice totalPrice){
        TourInstance tourInstance = new TourInstance(date, instanceID, numberOfPersons, totalPrice);
        //EVENTS
        return tourInstance;
    }
}