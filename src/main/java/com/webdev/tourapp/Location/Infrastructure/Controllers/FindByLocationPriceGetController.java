package com.webdev.tourapp.Location.Infrastructure.Controllers;


import com.webdev.tourapp.Location.Application.FindByPrice.LocationPriceFinder;
import com.webdev.tourapp.Location.Application.FindByPrice.LocationPriceFinderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value="/Location")
public class FindByLocationPriceGetController {

    @Autowired
    private LocationPriceFinder locationPriceFinder;

    @GetMapping(value ="/locationPrice")
    @ResponseBody
    public ResponseEntity<List<HashMap<String, Object>>> execute(@RequestParam("locationPrice") double locationPrice){
        LocationPriceFinderResponse response = locationPriceFinder.execute(locationPrice);
        return ResponseEntity.status(HttpStatus.OK).body(response.response());
    }
}