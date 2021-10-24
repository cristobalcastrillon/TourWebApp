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

    public String getGuideID() {
        return guideID;
    }

    public void setGuideID(String guideID) {
        this.guideID = guideID;
    }

    public String getGuideFirstName() {
        return guideFirstName;
    }

    public void setGuideFirstName(String guideFirstName) {
        this.guideFirstName = guideFirstName;
    }

    public String getGuideLastName() {
        return guideLastName;
    }

    public void setGuideLastName(String guideLastName) {
        this.guideLastName = guideLastName;
    }

    public Double getGuideBaseFare() {
        return guideBaseFare;
    }

    public void setGuideBaseFare(Double guideBaseFare) {
        this.guideBaseFare = guideBaseFare;
    }

    public String getGuidePhoneNumber() {
        return guidePhoneNumber;
    }

    public void setGuidePhoneNumber(String guidePhoneNumber) {
        this.guidePhoneNumber = guidePhoneNumber;
    }
}