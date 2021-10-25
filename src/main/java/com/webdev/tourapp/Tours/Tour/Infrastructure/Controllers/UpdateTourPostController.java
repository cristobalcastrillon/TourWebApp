package com.webdev.tourapp.Tours.Tour.Infrastructure.Controllers;

import com.webdev.tourapp.Tours.Tour.Application.Update.TourUpdater;
import com.webdev.tourapp.Tours.Tour.Domain.Entities.Location;
import com.webdev.tourapp.Tours.Tour.Domain.Exceptions.TourIDNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/Tour")
public class UpdateTourPostController {

    @Autowired
    private TourUpdater updater;

    @PostMapping(value = "/update")
    public ResponseEntity execute(@RequestParam("tourID") String tourID, @RequestBody TourRequest request) {
        this.updater.execute(tourID, request.getTourName(),
                request.getTourPrice(), request.getLocationsIncludedInTour());
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @ExceptionHandler(TourIDNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<HashMap> handleTourIDNotFound(TourIDNotFound exception) {
        HashMap<String, String> response = new HashMap<>() {{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    static class TourRequest {
        private String tourName;
        private Double tourPrice;
        private Optional<List<Location>> locationsIncludedInTour;

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