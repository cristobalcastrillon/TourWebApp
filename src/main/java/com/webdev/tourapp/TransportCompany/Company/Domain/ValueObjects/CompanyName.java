package com.webdev.tourapp.TransportCompany.Company.Domain.ValueObjects;

import com.webdev.tourapp.Shared.Domain.Aggregate.CustomUUID;

public class CompanyName extends CustomUUID {

    public CompanyName(String value) {
        super(value);
    }

    public CompanyName(){}

}