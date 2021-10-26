package com.webdev.tourapp.TransportCompany.Company.Application.FindByID;

import com.webdev.tourapp.TransportCompany.Company.Domain.Company;

import java.util.HashMap;

public class CompanyIDFinderResponse {
    private Company company;

    public CompanyIDFinderResponse(Company company){
        this.company = company;
    }

    public HashMap<String, Object> response() {
        HashMap<String, Object> response = new HashMap<>();
        response.put("compañia", company.data());
        return response;
    }
}