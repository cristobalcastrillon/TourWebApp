package com.webdev.tourapp.Tours.TourInstance.Infrastructure.Controllers;

import com.webdev.tourapp.Tours.TourInstance.Application.FindByID.TourInstanceIDFinder;
import com.webdev.tourapp.Tours.TourInstance.Application.FindByID.TourInstanceIDFinderResponse;
import com.webdev.tourapp.Tours.TourInstance.Domain.Exceptions.TourInstanceIDNotFound;
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

    @ExceptionHandler(TourInstanceIDNotFound.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity handleTourInstanceIDNotFound(TourInstanceIDNotFound exception) {
        HashMap<String, String> response = new HashMap<>() {{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
