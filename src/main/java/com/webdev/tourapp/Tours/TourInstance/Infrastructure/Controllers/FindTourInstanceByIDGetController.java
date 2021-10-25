package com.webdev.tourapp.Tours.TourInstance.Infrastructure.Controllers;

import com.webdev.tourapp.Tours.TourInstance.Application.FindByID.TourInstanceIDFinder;
import com.webdev.tourapp.Tours.TourInstance.Application.FindByID.TourInstanceIDFinderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/TourInstance")
public class FindTourInstanceByIDGetController {

    @Autowired
    private TourInstanceIDFinder idFinder;

    @GetMapping(value = "/tourInstanceID")
    @ResponseBody
    public ResponseEntity<HashMap<String, Object>> execute(@RequestParam("id")  String tourInstanceID){
        TourInstanceIDFinderResponse response = idFinder.execute(tourInstanceID);
        return ResponseEntity.status(HttpStatus.OK).body(response.response());
    }
}
