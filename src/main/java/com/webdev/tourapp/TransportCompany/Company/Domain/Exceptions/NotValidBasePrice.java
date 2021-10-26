package com.webdev.tourapp.TransportCompany.Company.Domain.Exceptions;

public class NotValidBasePrice extends RuntimeException {
    public NotValidBasePrice(String message) {
        super(message);
    }
}