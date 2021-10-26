package com.webdev.tourapp.TransportCompany.Company.Domain.Exceptions;

public class NoCompaniesFound extends RuntimeException {
    public NoCompaniesFound(String message) {
        super(message);
    }
}
