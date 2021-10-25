package com.webdev.tourapp.Tours.Tour.Infrastructure.Controllers;

import com.webdev.tourapp.Tours.Tour.Application.Delete.TourDeleter;
import com.webdev.tourapp.Tours.Tour.Domain.Exceptions.TourIDNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/Tour")
public class DeleteTourDeleteController {

    @Autowired
    private TourDeleter deleter;

    @DeleteMapping(value = "/delete")
    public ResponseEntity execute(@RequestParam("tourID") String tourID) {
        this.deleter.execute(tourID);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @ExceptionHandler(TourIDNotFound.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ResponseEntity<HashMap> handleTourIDNotFound(TourIDNotFound exception) {
        HashMap<String, String> response = new HashMap<>() {{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}