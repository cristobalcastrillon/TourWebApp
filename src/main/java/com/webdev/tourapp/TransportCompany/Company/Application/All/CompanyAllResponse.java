package com.webdev.tourapp.TransportCompany.Company.Application.All;

import com.webdev.tourapp.TransportCompany.Company.Domain.Company;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class CompanyAllResponse {

    private List<Company> company;

    public CompanyAllResponse(List<Company> company){
        this.company = company;
    }

    public List<HashMap<String, Object>> response() {
        List<HashMap<String, Object>> response = company.stream().map(element -> element.data()).collect(Collectors.toList());
        return response;
    }
}