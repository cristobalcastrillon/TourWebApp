package com.webdev.tourapp.Location.Infrastructure.Controllers;


import com.webdev.tourapp.Location.Application.FindByDescription.LocationDescriptionFinder;
import com.webdev.tourapp.Location.Application.FindByDescription.LocationDescriptionFinderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value="/Location")
public class FinderLocationByDescriptionGetController {

    @Autowired
    private LocationDescriptionFinder locationDescriptionFinder;


    @GetMapping(value ="/locationDescription")
    @ResponseBody
    public ResponseEntity<List<HashMap<String, Object>>> execute(@RequestParam("description") String description) {
        LocationDescriptionFinderResponse response = locationDescriptionFinder.execute(description);
        return ResponseEntity.status(HttpStatus.OK).body(response.response());
    }
}