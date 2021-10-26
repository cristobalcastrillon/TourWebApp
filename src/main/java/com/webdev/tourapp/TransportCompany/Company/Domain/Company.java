package com.webdev.tourapp.TransportCompany.Company.Domain;

import com.webdev.tourapp.TransportCompany.Company.Domain.ValueObjects.CompanyID;
import com.webdev.tourapp.TransportCompany.Company.Domain.ValueObjects.CompanyName;
import com.webdev.tourapp.TransportCompany.Company.Domain.ValueObjects.CompanyURL;
import com.webdev.tourapp.TransportCompany.Company.Domain.ValueObjects.CompanyCellphone;
import com.webdev.tourapp.TransportCompany.Company.Domain.ValueObjects.CompanyBasePrice;

import java.util.*;

public class Company {
    private CompanyID companyID;
    private CompanyName companyName;
    private CompanyBasePrice companyBasePrice;
    private CompanyCellphone companyCellphone;
    private CompanyURL companyURL;

    private Company(){}

    public Company(CompanyID id,
                   CompanyName name,
                   CompanyBasePrice price,
                   CompanyCellphone phone,
                   CompanyURL url
    ){
        this.companyID = id;
        this.companyName = name;
        this.companyBasePrice = price;
        this.companyCellphone = phone;
        this.companyURL = url;
    }

    public static Company Create(CompanyID id,
                                 CompanyName name,
                                 CompanyBasePrice price,
                                 CompanyCellphone phone,
                                 CompanyURL url
    ){

        Company company = new Company(id, name, price, phone, url);
        return company;
    }

    public HashMap<String, Object> data() {
        HashMap<String, Object> data = new HashMap<>(){{
            put("id", companyID.value());
            put("name", companyName.value());
            put("price", companyBasePrice.value());
            put("phone", companyCellphone.value());
            put("url", companyURL.value());
        }};
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return companyID.equals(company.companyID) && companyName.equals(company.companyName) && companyBasePrice.equals(company.companyBasePrice) && companyCellphone.equals(company.companyCellphone) && companyURL.equals(company.companyURL) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyID, companyName, companyBasePrice, companyCellphone, companyURL);
    }
}