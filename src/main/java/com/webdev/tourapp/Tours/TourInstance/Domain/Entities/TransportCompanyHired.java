package com.webdev.tourapp.Tours.TourInstance.Domain.Entities;

import java.util.HashMap;
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

    public HashMap<String, Object> dataDB(){
        return new HashMap<>(){{
            put("companyID", companyID);
            put("companyName", companyName);
            put("companyPhoneNumber", companyPhoneNumber);
            put("companyURL", companyURL);
            put("companyBaseFare", companyBaseFare);
        }};
    }

    public String getCompanyID() {
        return companyID;
    }

    public void setCompanyID(String companyID) {
        this.companyID = companyID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyPhoneNumber() {
        return companyPhoneNumber;
    }

    public void setCompanyPhoneNumber(String companyPhoneNumber) {
        this.companyPhoneNumber = companyPhoneNumber;
    }

    public Optional<String> getCompanyURL() {
        return companyURL;
    }

    public void setCompanyURL(Optional<String> companyURL) {
        this.companyURL = companyURL;
    }

    public Double getCompanyBaseFare() {
        return companyBaseFare;
    }

    public void setCompanyBaseFare(Double companyBaseFare) {
        this.companyBaseFare = companyBaseFare;
    }
}