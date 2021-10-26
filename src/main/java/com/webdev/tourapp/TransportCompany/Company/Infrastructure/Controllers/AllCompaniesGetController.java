package com.webdev.tourapp.TransportCompany.Company.Infrastructure;

import com.webdev.tourapp.TransportCompany.Company.Application.All.CompanyAll;
import com.webdev.tourapp.TransportCompany.Company.Application.All.CompanyAllResponse;
import com.webdev.tourapp.TransportCompany.Company.Domain.Exceptions.NoCompaniesFoundForSpecifiedCompanyName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/Company")
public class AllCompaniesGetController {

    @Autowired
    private CompanyAll all;

    @GetMapping(value = "/")
    public ResponseEntity<List<HashMap<String, Object>>> execute() {
        CompanyAllResponse response = all.execute();
        return ResponseEntity.status(HttpStatus.OK).body(response.response());
    }

    @ExceptionHandler(NoCompaniesFoundForSpecifiedCompanyName.class)
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public ResponseEntity<HashMap> handleNoToursFound(NoCompaniesFoundForSpecifiedCompanyName exception) {
        HashMap<String, String> response = new HashMap<>() {{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
    }
}