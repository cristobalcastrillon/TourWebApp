package com.webdev.tourapp.TransportCompany.Company.Application.FindByCompanyName;

import com.webdev.tourapp.TransportCompany.Company.Domain.Company;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class CompanyNameFinderResponse {
    private List<Company> companyList;

    public CompanyNameFinderResponse(List<Company> companyList){
        this.companyList = companyList;
    }

    public List<HashMap<String, Object>> response() {
        List<HashMap<String, Object>> response = companyList.stream().map(element -> element.data()).collect(Collectors.toList());
        return response;
    }
}