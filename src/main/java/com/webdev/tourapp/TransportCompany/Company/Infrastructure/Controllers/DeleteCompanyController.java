package com.webdev.tourapp.TransportCompany.Company.Infrastructure.Controllers;

import com.webdev.tourapp.TransportCompany.Company.Application.Delete.CompanyDeleter;
import com.webdev.tourapp.TransportCompany.Company.Domain.Exceptions.CompanyIDNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/Company")
public class DeleteCompanyController {

    @Autowired
    private CompanyDeleter deleter;

    @DeleteMapping(value = "/delete")
    public ResponseEntity execute(@RequestParam("companyID") String companyID) {
        this.deleter.execute(companyID);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @ExceptionHandler(CompanyIDNotFound.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ResponseEntity<HashMap> handleTourIDNotFound(CompanyIDNotFound exception) {
        HashMap<String, String> response = new HashMap<>() {{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}