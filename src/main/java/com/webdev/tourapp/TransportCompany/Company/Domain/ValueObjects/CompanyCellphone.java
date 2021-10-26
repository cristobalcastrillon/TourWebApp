package com.webdev.tourapp.TransportCompany.Company.Domain.ValueObjects;


import com.webdev.tourapp.Shared.Domain.Aggregate.CustomUUID;

public class CompanyCellphone extends CustomUUID {

    public CompanyCellphone(String value) {
        super(value);
    }

    public CompanyCellphone(){}

}