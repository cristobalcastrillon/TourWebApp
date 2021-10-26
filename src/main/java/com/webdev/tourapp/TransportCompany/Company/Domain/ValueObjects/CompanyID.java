package com.webdev.tourapp.TransportCompany.Company.Domain.ValueObjects;

import com.webdev.tourapp.Shared.Domain.Aggregate.CustomUUID;

public class CompanyID extends CustomUUID {

    public CompanyID(String value) {
        super(value);
    }

    public CompanyID(){}

}