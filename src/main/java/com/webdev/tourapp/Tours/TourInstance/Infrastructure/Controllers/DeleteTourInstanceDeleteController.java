package com.webdev.tourapp.Tours.TourInstance.Infrastructure.Controllers;

import com.webdev.tourapp.Tours.TourInstance.Application.Delete.TourInstanceDeleter;
import com.webdev.tourapp.Tours.TourInstance.Domain.Exceptions.TourInstanceIDNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/TourInstance")
public class DeleteTourInstanceDeleteController {

    @Autowired
    private TourInstanceDeleter deleter;

    @DeleteMapping(value = "/delete")
    public ResponseEntity execute(@RequestParam("id") String tourInstanceID) {
        this.deleter.execute(tourInstanceID);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @ExceptionHandler(TourInstanceIDNotFound.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ResponseEntity<HashMap> handleTourIDNotFound(TourInstanceIDNotFound exception) {
        HashMap<String, String> response = new HashMap<>() {{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}