package com.webdev.tourapp.Location.Infrastructure.Controllers;

import com.webdev.tourapp.Location.Application.Delete.LocationDeleter;
import com.webdev.tourapp.Location.Domain.Exceptions.LocationIDNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/Location")
public class DeleteLocationDeleteController {

    @Autowired
    private LocationDeleter deleter;

    @DeleteMapping(value = "/delete")
    public ResponseEntity execute(@RequestParam("locationID") String locationID) {
        this.deleter.deleter(locationID);
        return ResponseEntity.status(HttpStatus.OK).body(null);

    }

    @ExceptionHandler(LocationIDNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ResponseEntity<HashMap> handleLocationIDNotFoundException(LocationIDNotFoundException e) {
        HashMap<String, String> error = new HashMap<>(){{
            put("error", e.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

}