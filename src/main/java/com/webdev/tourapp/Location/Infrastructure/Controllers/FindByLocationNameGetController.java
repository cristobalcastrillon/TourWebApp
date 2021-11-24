package com.webdev.tourapp.Location.Infrastructure.Controllers;


import com.webdev.tourapp.Location.Application.FindByID.LocationIDFinder;
import com.webdev.tourapp.Location.Application.FindByLocationName.LocationNameFinder;
import com.webdev.tourapp.Location.Application.FindByLocationName.LocationNameFinderResponse;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value="/Location")
public class FindByLocationNameGetController {

    @Autowired
    private LocationNameFinder locationNameFinder;

    @GetMapping(value ="/locationName")
    @ResponseBody
    public ResponseEntity<List<HashMap<String,Object>>> execute(@RequestParam("locationName") String locationName) {
        LocationNameFinderResponse response = locationNameFinder.execute(locationName);
        return ResponseEntity.status(HttpStatus.OK).body(response.response());
    }

}