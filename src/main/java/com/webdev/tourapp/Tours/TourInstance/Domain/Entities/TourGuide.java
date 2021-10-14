package com.webdev.tourapp.Tours.TourInstance.Domain.Entities;

import java.util.Objects;

public class TourGuide {

    String guideID;
    String guideFirstName;
    String guideLastName;
    Double guideBaseFare;
    String guidePhoneNumber;

    private TourGuide(){}
    public TourGuide(String id, String firstName, String lastName, Double baseFare, String phoneNumber){
        this.guideID = id;
        this.guideFirstName = firstName;
        this.guideLastName = lastName;
        this.guideBaseFare = baseFare;
        this.guidePhoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TourGuide tourGuide = (TourGuide) o;
        return guideID.equals(tourGuide.guideID) && guideFirstName.equals(tourGuide.guideFirstName) && guideLastName.equals(tourGuide.guideLastName) && guideBaseFare.equals(tourGuide.guideBaseFare) && guidePhoneNumber.equals(tourGuide.guidePhoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(guideID, guideFirstName, guideLastName, guideBaseFare, guidePhoneNumber);
    }
}