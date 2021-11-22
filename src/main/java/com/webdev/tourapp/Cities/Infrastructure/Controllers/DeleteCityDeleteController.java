package com.webdev.tourapp.Cities.Infrastructure.Controllers;

import com.webdev.tourapp.Cities.Application.Delete.CityDeleter;
import com.webdev.tourapp.Cities.Domain.Exceptions.CityIDNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value="/City")
public class DeleteCityDeleteController {

    @Autowired
    private CityDeleter deleter;

    @DeleteMapping(value="/Delete")
    public ResponseEntity execute(@RequestParam("cityID") String cityID) {
        this.deleter.deleter(cityID);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @ExceptionHandler(CityIDNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ResponseEntity<HashMap> handleCityIDNotFound(CityIDNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new HashMap<String, String>() {{
            put("error", exception.getMessage());
        }});
    }
}