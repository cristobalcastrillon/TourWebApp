package com.webdev.tourapp.TransportCompany.Company.Domain.Ports;

import com.webdev.tourapp.TransportCompany.Company.Domain.Company;
import com.webdev.tourapp.TransportCompany.Company.Domain.ValueObjects.CompanyID;
import com.webdev.tourapp.TransportCompany.Company.Domain.ValueObjects.CompanyName;
import com.webdev.tourapp.TransportCompany.Company.Domain.ValueObjects.CompanyBasePrice;
import com.webdev.tourapp.TransportCompany.Company.Domain.ValueObjects.CompanyURL;
import com.webdev.tourapp.TransportCompany.Company.Domain.ValueObjects.CompanyCellphone;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository {
    void save(Company company);
    void update(Company company);
    void delete(Company company);
    Optional<List<Company>> all();
    Optional<Company> findByID(CompanyID companyID);
    Optional<List<Company>> findByCompanyName(CompanyName nameQuery);
}