package com.webdev.tourapp.Tours.Tour.Infrastructure.Controllers;

import com.webdev.tourapp.Tours.Tour.Application.FindByID.TourIDFinder;
import com.webdev.tourapp.Tours.Tour.Application.FindByID.TourIDFinderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/Tour")
public class FindTourByIDGetController {

    @Autowired
    private TourIDFinder idFinder;

    @GetMapping(value = "/tourID")
    @ResponseBody
    public ResponseEntity<HashMap<String, Object>> execute(@RequestParam("tourID") String tourID){
        TourIDFinderResponse response = idFinder.execute(tourID);
        return ResponseEntity.status(HttpStatus.OK).body(response.response());
    }
}
