package com.webdev.tourapp.Tours.TourInstance.Domain.ValueObjects;

import com.webdev.tourapp.Shared.Domain.Aggregate.DateValueObject;

import java.util.Date;

public class TourDate extends DateValueObject {

    public TourDate(Date value){ super(value); }

}