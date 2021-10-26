package com.webdev.tourapp.TransportCompany.Company.Domain.ValueObjects;


import com.webdev.tourapp.Shared.Domain.Aggregate.CustomUUID;

public class CompanyURL extends CustomUUID {

    public CompanyURL(String value) {
        super(value);
    }

    public CompanyURL(){}

}