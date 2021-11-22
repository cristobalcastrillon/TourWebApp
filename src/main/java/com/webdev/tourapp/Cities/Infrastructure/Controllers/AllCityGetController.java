package com.webdev.tourapp.Cities.Infrastructure.Controllers;

import com.webdev.tourapp.Cities.Application.All.CityAll;
import com.webdev.tourapp.Cities.Application.All.CityAllResponse;
import com.webdev.tourapp.Cities.Domain.Exceptions.NoCitiesFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/City")
public class AllCityGetController {
    @Autowired
    private CityAll all;

    @GetMapping(value = "/")
    public ResponseEntity<List<HashMap<String,Object>>> execute(){
        CityAllResponse response = all.execute();
        return ResponseEntity.status(HttpStatus.OK).body(response.response());
    }
    @ExceptionHandler(NoCitiesFound.class)
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public ResponseEntity<HashMap> handleNoCityFound(NoCitiesFound exeption){
        HashMap<String,String> response = new HashMap<>(){{
            put("error",exeption.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
    }
}