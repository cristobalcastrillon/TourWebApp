package com.webdev.tourapp.Tours.TourInstance.Domain.Entities;

import java.util.HashMap;
import java.util.Objects;

public class TourGuide {

    String guideID;

    private TourGuide(){}

    public TourGuide(String id){
        this.guideID = id;
    }

    public HashMap<String, Object> dataDB(){
        return new HashMap<>(){{
            put("guideID", guideID);
        }};
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TourGuide tourGuide = (TourGuide) o;
        return guideID.equals(tourGuide.guideID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(guideID);
    }

    public String getGuideID() {
        return guideID;
    }

    public void setGuideID(String guideID) {
        this.guideID = guideID;
    }

}