package com.webdev.tourapp.Tours.Tour.Infrastructure.Controllers;

import com.webdev.tourapp.Tours.Tour.Application.All.TourAll;
import com.webdev.tourapp.Tours.Tour.Application.All.TourAllResponse;
import com.webdev.tourapp.Tours.Tour.Domain.Exceptions.NoToursFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @ExceptionHandler(NoToursFound.class)
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public ResponseEntity<HashMap> handleNoToursFound(NoToursFound exception) {
        HashMap<String, String> response = new HashMap<>() {{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
    }
}
