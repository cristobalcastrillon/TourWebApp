package com.webdev.tourapp.Cities.Infrastructure.Controllers;


import com.webdev.tourapp.Cities.Application.FindByDefaultIATA.CityDefaultIATAFinder;
import com.webdev.tourapp.Cities.Application.FindByDefaultIATA.CityDefaultIATAFinderResponse;
import com.webdev.tourapp.Cities.Domain.Exceptions.CityDefaultIATANotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/City")
public class FindCityByDefaultIATAGetController {

    @Autowired
    private CityDefaultIATAFinder cityDefaultIATAFinder;

    @GetMapping(value = "/cityDefaultIATA")
    @ResponseBody
    public ResponseEntity<List<HashMap<String,Object>>> execute(@RequestParam("cityDefaultIATA") String cityDefaultIATA) {
        CityDefaultIATAFinderResponse response = cityDefaultIATAFinder.execute(cityDefaultIATA);
        return ResponseEntity.status(HttpStatus.OK).body(response.response());
    }

    @ExceptionHandler(CityDefaultIATANotFound.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ResponseEntity<HashMap> handleCityDefaultIATANotFound(CityDefaultIATANotFound exeption) {
        HashMap<String, String> response = new HashMap<>(){{
            put("message", exeption.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}