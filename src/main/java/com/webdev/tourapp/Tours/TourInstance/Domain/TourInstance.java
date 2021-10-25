package com.webdev.tourapp.Tours.TourInstance.Domain;

import com.webdev.tourapp.Shared.Domain.Aggregate.AggregateRoot;
import com.webdev.tourapp.Tours.TourInstance.Domain.Entities.StartingLocation;
import com.webdev.tourapp.Tours.TourInstance.Domain.Entities.TourGuide;
import com.webdev.tourapp.Tours.TourInstance.Domain.Entities.TourUser;
import com.webdev.tourapp.Tours.TourInstance.Domain.Entities.TransportCompanyHired;
import com.webdev.tourapp.Tours.TourInstance.Domain.ValueObjects.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class TourInstance extends AggregateRoot {
    TourDate tourDate;
    TourInstanceID tourInstanceID;
    TourNumberOfPersons tourNumberOfPersons;
    TourTotalPrice tourTotalPrice;
    TourInstanceStatus tourInstanceStatus;
    Optional<TourGuide> tourGuide;
    Optional<StartingLocation> startingLocation;
    Optional<List<TourUser>> tourUsers;
    Optional<TransportCompanyHired> transportCompanyHired;
    AssociatedTourID associatedTourID;

    public TourInstance(){}

    public TourInstance(TourDate date,
                        TourInstanceID instanceID,
                        TourNumberOfPersons numberOfPersons,
                        TourTotalPrice totalPrice,
                        TourInstanceStatus status,
                        Optional<TourGuide> guide,
                        Optional<StartingLocation> sLocation,
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
                                      Optional<TourGuide> guide,
                                      Optional<StartingLocation> sLocation,
                                      Optional<List<TourUser>> users,
                                      Optional<TransportCompanyHired> companyHired,
                                      AssociatedTourID associatedTourID){

        TourInstance tourInstance = new TourInstance(date, instanceID, numberOfPersons, totalPrice, status, guide, sLocation, users, companyHired, associatedTourID);
        //EVENTS
        return tourInstance;
    }

    public HashMap<String, Object> data() {
        HashMap<String, Object> data = new HashMap<>(){{
            put("tourDate", tourDate.value());
            put("tourInstanceID", tourInstanceID.value());
            put("tourNumberOfPersons", tourNumberOfPersons.value());
            put("tourTotalPrice", tourTotalPrice.value());
            put("tourInstanceStatus", tourInstanceStatus.value());
            put("associatedTourID", associatedTourID.value());
        }};
        data.put("tourUsers", this.dataUsers());
        data.put("tourGuide", this.dataGuide());
        data.put("startingLocation", this.dataStartingLocation());
        data.put("transportCompanyHired", this.dataTransportCompanyHired());
        return data;
    }

    public List<HashMap<String, Object>> dataUsers(){
        List<HashMap<String, Object>> data = new ArrayList<>();
        if(tourUsers.isPresent()){
            for (TourUser user : tourUsers.get()) {
                HashMap<String, Object> userJSON = new HashMap<>();
                userJSON.put("location", user.dataDB());
                data.add(userJSON);
            }
        }
        else{
            data = null;
        }
        return data;
    }

    public HashMap<String, Object> dataGuide() {
        HashMap<String, Object> data = new HashMap<>();
        if(this.tourGuide.isPresent()){
            data.put("tourGuide", this.tourGuide.get().dataDB());
        }
        else{
            data.put("tourGuide", null);
        }
        return data;
    }

    public HashMap<String, Object> dataStartingLocation() {
        HashMap<String, Object> data = new HashMap<>();
        if(this.startingLocation.isPresent()){
            data.put("startingLocation", this.startingLocation.get().dataDB());
        }
        else{
            data.put("startingLocation", null);
        }
        return data;
    }

    public HashMap<String, Object> dataTransportCompanyHired() {
        HashMap<String, Object> data = new HashMap<>();
        if(this.transportCompanyHired.isPresent()){
            data.put("transportCompanyHired", this.transportCompanyHired.get().dataDB());
        }
        else{
            data.put("transportCompanyHired", null);
        }
        return data;
    }

}