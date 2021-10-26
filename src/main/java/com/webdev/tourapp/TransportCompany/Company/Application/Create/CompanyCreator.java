package com.webdev.tourapp.TransportCompany.Company.Application.Create;


import com.webdev.tourapp.TransportCompany.Company.Domain.Company;
import com.webdev.tourapp.TransportCompany.Company.Domain.Ports.CompanyRepository;
import com.webdev.tourapp.TransportCompany.Company.Domain.Exceptions.CompanyAlreadyExists;
import com.webdev.tourapp.TransportCompany.Company.Domain.ValueObjects.CompanyID;
import com.webdev.tourapp.TransportCompany.Company.Domain.ValueObjects.CompanyName;
import com.webdev.tourapp.TransportCompany.Company.Domain.ValueObjects.CompanyURL;
import com.webdev.tourapp.TransportCompany.Company.Domain.ValueObjects.CompanyCellphone;
import com.webdev.tourapp.TransportCompany.Company.Domain.ValueObjects.CompanyBasePrice;


import java.util.List;
import java.util.Optional;

public class CompanyCreator {

    private CompanyRepository repository;

    public CompanyCreator(CompanyRepository repository) {
        this.repository = repository;
    }

    public void execute(String id,
                        String name,
                        String url,
                        String cellphone,
                        Double price) {
        this.validate(id);
        Company company = Company.Create(new CompanyID(id), new CompanyName(name), new CompanyBasePrice(price), new CompanyCellphone(cellphone), new CompanyURL(url));
        Company transport;
        repository.save(company);
    }

    private void validate(String CompanyID) {
        Optional<Company> transport = repository.findByID(new CompanyID(CompanyID));
        if (transport.isPresent()) {
            throw new CompanyAlreadyExists("La compañia de transporte con id " + CompanyID.toString() + " ya existe.");
        }
    }
}