package com.webdev.tourapp.TransportCompany.Company.Domain.Exceptions;

public class NoCompaniesFoundForSpecifiedCompanyName extends RuntimeException {
    public NoCompaniesFoundForSpecifiedCompanyName(String message) {
        super(message);
    }
}