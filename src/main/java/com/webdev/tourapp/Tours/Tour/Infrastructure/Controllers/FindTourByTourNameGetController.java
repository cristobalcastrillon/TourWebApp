package com.webdev.tourapp.Tours.Tour.Infrastructure.Controllers;

import com.webdev.tourapp.Tours.Tour.Application.FindByTourName.TourNameFinder;
import com.webdev.tourapp.Tours.Tour.Application.FindByTourName.TourNameFinderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/Tour")
public class FindTourByTourNameGetController {

    @Autowired
    private TourNameFinder nameFinder;

    @GetMapping(value = "/tourName")
    @ResponseBody
    public ResponseEntity<List<HashMap<String, Object>>> execute(@RequestParam("name") String tourName) {
        TourNameFinderResponse response = nameFinder.execute(tourName);
        return ResponseEntity.status(HttpStatus.OK).body(response.response());
    }
}
