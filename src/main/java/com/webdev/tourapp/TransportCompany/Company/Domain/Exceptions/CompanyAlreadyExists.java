package com.webdev.tourapp.TransportCompany.Company.Domain.Exceptions;

public class CompanyAlreadyExists extends RuntimeException {
    public CompanyAlreadyExists(String message) {
        super(message);
    }
}
