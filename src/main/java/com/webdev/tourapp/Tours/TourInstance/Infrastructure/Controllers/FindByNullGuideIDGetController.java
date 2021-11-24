package com.webdev.tourapp.Tours.TourInstance.Infrastructure.Controllers;

import com.webdev.tourapp.Tours.TourInstance.Application.All.TourInstanceAllResponse;
import com.webdev.tourapp.Tours.TourInstance.Application.FindByNullGuideID.TourInstanceNullGuideIDFinder;
import com.webdev.tourapp.Tours.TourInstance.Application.FindByNullGuideID.TourInstanceNullGuideIDFinderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/TourInstance")
public class FindByNullGuideIDGetController {
    @Autowired
    private TourInstanceNullGuideIDFinder nullGuideIDFinder;

    @GetMapping(value = "/toursNoGuide")
    public ResponseEntity<List<HashMap<String, Object>>> execute() {
        TourInstanceNullGuideIDFinderResponse response = nullGuideIDFinder.execute();
        return ResponseEntity.status(HttpStatus.OK).body(response.response());
    }
}
