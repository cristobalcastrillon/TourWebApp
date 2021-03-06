package com.webdev.tourapp.Tours.Tour.Infrastructure.Controllers;

import com.webdev.tourapp.Tours.Tour.Application.Create.TourCreator;
import com.webdev.tourapp.Tours.Tour.Domain.Entities.Location;
import com.webdev.tourapp.Tours.Tour.Domain.Exceptions.NotValidTourPrice;
import com.webdev.tourapp.Tours.Tour.Domain.Exceptions.TourAlreadyExists;
import com.webdev.tourapp.Tours.Tour.Domain.Exceptions.TourNameNotValid;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
//TODO: Document REST API
//@Tag(name = "Tour", description = "This is the Tour API. A Tour is a collection of locations in a city, arranged (but not necessarily) following a theme criteria: say, for example, a tour including Roman imperial monuments in Rome.")
@RequestMapping(value = "/Tour")
public class CreateTourPostController {

    @Autowired
    private TourCreator creator;

    //@Operation(summary = "Create a new Tour", description = "You can create a Tour by providing a list of locations included in it and naming it.")
    @PostMapping(value = "/")
    public ResponseEntity execute(@RequestBody TourRequest request){
        this.creator.execute(request.getTourID(), request.getTourName(), request.getTourPrice(), request.getLocationsIncludedInTour());
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @ExceptionHandler(TourAlreadyExists.class)
    @ResponseStatus(code = HttpStatus.CONFLICT)
    public ResponseEntity<HashMap> handleTourAlreadyExists(TourAlreadyExists exception) {
        HashMap<String, String> response = new HashMap<>() {{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @ExceptionHandler({TourNameNotValid.class, NotValidTourPrice.class})
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ResponseEntity<HashMap> handleBadRequest(RuntimeException exception) {
        HashMap<String, String> response = new HashMap<>() {{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    static class TourRequest {
        private String tourID;
        private String tourName;
        private Double tourPrice;
        private Optional<List<Location>> locationsIncludedInTour;

        public String getTourID() {
            return tourID;
        }

        public void setTourID(String tourID) {
            this.tourID = tourID;
        }

        public String getTourName() {
            return tourName;
        }

        public void setTourName(String tourName) {
            this.tourName = tourName;
        }

        public Double getTourPrice() {
            return tourPrice;
        }

        public void setTourPrice(Double tourPrice) {
            this.tourPrice = tourPrice;
        }

        public Optional<List<Location>> getLocationsIncludedInTour() {
            return locationsIncludedInTour;
        }

        public void setLocationsIncludedInTour(Optional<List<Location>> locationsIncludedInTour) {
            this.locationsIncludedInTour = locationsIncludedInTour;
        }

        public TourRequest() {}
    }
}
