package com.webdev.tourapp.Location.Infrastructure.Controllers;

import com.webdev.tourapp.Location.Application.FindByID.LocationIDFinder;
import com.webdev.tourapp.Location.Application.FindByID.LocationIDFinderResponse;
import com.webdev.tourapp.Location.Domain.Exceptions.LocationIDNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value="/Location")
public class FinderLocationByIDGetController {

    @Autowired
    private LocationIDFinder locationIDFinder;

    @GetMapping(value ="/locationID")
    @ResponseBody
    public ResponseEntity<HashMap<String,Object>> execute(@RequestParam("locationId") String locationId) {
        LocationIDFinderResponse response = locationIDFinder.execute(locationId);
        return ResponseEntity.status(HttpStatus.OK).body(response.response());
    }

    @ExceptionHandler(LocationIDNotFoundException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ResponseEntity<HashMap> handleLocationIDNotFoundException(LocationIDNotFoundException ex) {
        HashMap<String, Object> response = new HashMap<>(){{
            put("error", ex.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}