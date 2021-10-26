package com.webdev.tourapp.TransportCompany.Company.Domain.Exceptions;

public class CompanyIDNotFound extends RuntimeException {
    public CompanyIDNotFound(String message) {
        super(message);
    }
}