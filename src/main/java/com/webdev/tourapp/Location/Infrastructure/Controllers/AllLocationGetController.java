package com.webdev.tourapp.Location.Infrastructure.Controllers;

import com.webdev.tourapp.Location.Application.All.LocationAll;
import com.webdev.tourapp.Location.Application.All.LocationAllResponse;
import com.webdev.tourapp.Location.Domain.Exceptions.NoLocationsFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value="/Location")
public class AllLocationGetController {
    @Autowired
    private LocationAll all;

    @GetMapping(value="/")
    public ResponseEntity<List<HashMap<String,Object>>> execute(){
        LocationAllResponse response = all.execute();
        return ResponseEntity.status(HttpStatus.OK).body(response.response());
    }
    @ExceptionHandler(NoLocationsFoundException.class)
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public ResponseEntity<HashMap> handleNoLocationsFoundException(NoLocationsFoundException exception){
        HashMap<String,String> response = new HashMap<>(){
            {
                put("error",exception.getMessage());
            }
        };
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
    }

}