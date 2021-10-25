package com.webdev.tourapp.Tours.TourInstance.Infrastructure.Controllers;

import com.webdev.tourapp.Tours.TourInstance.Application.All.TourInstanceAll;
import com.webdev.tourapp.Tours.TourInstance.Application.All.TourInstanceAllResponse;
import com.webdev.tourapp.Tours.TourInstance.Domain.Exceptions.NoTourInstancesFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/TourInstance")
public class AllTourInstancesGetController {

    @Autowired
    private TourInstanceAll all;

    @GetMapping(value = "/")
    public ResponseEntity<List<HashMap<String, Object>>> execute() {
        TourInstanceAllResponse response = all.execute();
        return ResponseEntity.status(HttpStatus.OK).body(response.response());
    }

    @ExceptionHandler(NoTourInstancesFound.class)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity handleNoTourInstancesFound(NoTourInstancesFound exception) {
        HashMap<String, String> response = new HashMap<>() {{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
    }
}