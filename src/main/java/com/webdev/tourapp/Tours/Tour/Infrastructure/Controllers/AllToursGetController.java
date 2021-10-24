package com.webdev.tourapp.Tours.Tour.Infrastructure.Controllers;

import com.webdev.tourapp.Tours.Tour.Application.All.TourAll;
import com.webdev.tourapp.Tours.Tour.Application.All.TourAllResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/Tour")
public class AllToursGetController {

    @Autowired
    private TourAll all;

    @GetMapping(value = "/")
    public ResponseEntity<List<HashMap<String, Object>>> execute() {
        TourAllResponse response = all.execute();
        return ResponseEntity.status(HttpStatus.OK).body(response.response());
    }
}
