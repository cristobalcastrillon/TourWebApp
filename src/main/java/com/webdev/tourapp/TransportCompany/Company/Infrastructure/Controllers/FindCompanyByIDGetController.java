package com.webdev.tourapp.TransportCompany.Company.Infrastructure.Controllers;

import com.webdev.tourapp.TransportCompany.Company.Application.FindByID.CompanyIDFinder;
import com.webdev.tourapp.TransportCompany.Company.Application.FindByID.CompanyIDFinderResponse;
import com.webdev.tourapp.TransportCompany.Company.Domain.Exceptions.CompanyIDNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/Company")
public class FindCompanyByIDGetController {

    @Autowired
    private CompanyIDFinder idFinder;

    @GetMapping(value = "/companyID")
    @ResponseBody
    public ResponseEntity<HashMap<String, Object>> execute(@RequestParam("companyID") String tourID){
        CompanyIDFinderResponse response = idFinder.execute(tourID);
        return ResponseEntity.status(HttpStatus.OK).body(response.response());
    }

    @ExceptionHandler(CompanyIDNotFound.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ResponseEntity<HashMap> handleCompanyIDNotFound(CompanyIDNotFound exception) {
        HashMap<String, String> response = new HashMap<>() {{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}