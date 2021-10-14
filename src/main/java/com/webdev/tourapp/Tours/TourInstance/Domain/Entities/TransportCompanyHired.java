package com.webdev.tourapp.Tours.TourInstance.Domain.Entities;

import java.util.Optional;

public class TransportCompanyHired {

    String companyID;
    String companyName;
    String companyPhoneNumber;
    Optional<String> companyURL;
    Double companyBaseFare;

    private TransportCompanyHired(){}

    public TransportCompanyHired(String id,
                                 String name,
                                 String phoneNumber,
                                 Optional<String> url,
                                 Double baseFare){
        this.companyID = id;
        this.companyName = name;
        this.companyPhoneNumber = phoneNumber;
        this.companyURL = url;
        this.companyBaseFare = baseFare;
    }

}