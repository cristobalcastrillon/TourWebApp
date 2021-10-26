package com.webdev.tourapp.TransportCompany.Company.Infrastructure;

import com.webdev.tourapp.TransportCompany.Company.Application.FindByCompanyName.CompanyNameFinder;
import com.webdev.tourapp.TransportCompany.Company.Application.FindByCompanyName.CompanyNameFinderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/Company")
public class FindCompanyByCompanyNameGetController {

    @Autowired
    private CompanyNameFinder nameFinder;

    @GetMapping(value = "/companyName")
    @ResponseBody
    public ResponseEntity<List<HashMap<String, Object>>> execute(@RequestParam("name") String tourName) {
        CompanyNameFinderResponse response = nameFinder.execute(tourName);
        return ResponseEntity.status(HttpStatus.OK).body(response.response());
    }
}