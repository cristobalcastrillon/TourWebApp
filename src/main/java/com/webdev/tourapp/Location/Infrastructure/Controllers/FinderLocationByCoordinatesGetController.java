package com.webdev.tourapp.Location.Infrastructure.Controllers;

import com.webdev.tourapp.Location.Application.FindByCoordinates.LocationCoordinatesFinder;
import com.webdev.tourapp.Location.Application.FindByCoordinates.LocationCoordinatesFinderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value="/Location")
public class FinderLocationByCoordinatesGetController {

    @Autowired
    private LocationCoordinatesFinder locationCoordinatesFinder;


    @GetMapping(value ="/locationCoordinates")
    @ResponseBody
    public ResponseEntity<List<HashMap<String,Object>>> execute(@RequestParam("coordinates") String coordinates) {
        LocationCoordinatesFinderResponse response = locationCoordinatesFinder.execute(coordinates);
        return ResponseEntity.status(HttpStatus.OK).body(response.response());
    }
}