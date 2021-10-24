package com.webdev.tourapp.Tours.Tour.Infrastructure.Controllers;

import com.webdev.tourapp.Tours.Tour.Application.Create.TourCreator;
import com.webdev.tourapp.Tours.Tour.Domain.Entities.Location;
import com.webdev.tourapp.Tours.Tour.Domain.Exceptions.NotValidTourPrice;
import com.webdev.tourapp.Tours.Tour.Domain.Exceptions.TourAlreadyExists;
import com.webdev.tourapp.Tours.Tour.Domain.Exceptions.TourNameNotValid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/Tour")
public class CreateTourPostController {

    @Autowired
    private TourCreator creator;

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
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
        private List<Location> locationsIncludedInTour;

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

        public List<Location> getLocationsIncludedInTour() {
            return locationsIncludedInTour;
        }

        public void setLocationsIncludedInTour(List<Location> locationsIncludedInTour) {
            this.locationsIncludedInTour = locationsIncludedInTour;
        }

        public TourRequest() {}
    }
}
