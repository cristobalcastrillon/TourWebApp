package com.webdev.tourapp.Location.Infrastructure.Controllers;

import com.webdev.tourapp.Location.Application.Update.LocationUpdater;
import com.webdev.tourapp.Location.Domain.Exceptions.LocationIDNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/Location")
public class UpdateLocationPostController {
    @Autowired
    private LocationUpdater updater;

    @PostMapping(value = "/update")
    public ResponseEntity execute(@RequestParam(value = "locationID") String locationID, @RequestBody LocationRequest request) {
        this.updater.execute(
                locationID,
                request.getLocationName(),
                request.getLocationCoordinates(),
                request.getLocationDescription(),
                request.getLocationWebsiteURL(),
                request.getLocationCategory(),
                request.getLocationPrice());
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @ExceptionHandler(LocationIDNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<HashMap> handleLocationIDNotFoundException(LocationIDNotFoundException e) {
        HashMap<String, String> error = new HashMap<>(){{
            put("error", e.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    static class LocationRequest {
        private String locationName;
        private String locationCoordinates;
        private String locationDescription;
        private String locationWebsiteURL;
        private String locationCategory;
        private double locationPrice;

        public String getLocationName() {
            return locationName;
        }

        public void setLocationName(String locationName) {
            this.locationName = locationName;
        }

        public String getLocationCoordinates() {
            return locationCoordinates;
        }

        public void setLocationCoordinates(String locationCoordinates) {
            this.locationCoordinates = locationCoordinates;
        }

        public String getLocationDescription() {
            return locationDescription;
        }

        public void setLocationDescription(String locationDescription) {
            this.locationDescription = locationDescription;
        }

        public String getLocationWebsiteURL() {
            return locationWebsiteURL;
        }

        public void setLocationWebsiteURL(String locationWebsiteURL) {
            this.locationWebsiteURL = locationWebsiteURL;
        }

        public String getLocationCategory() {
            return locationCategory;
        }

        public void setLocationCategory(String locationCategory) {
            this.locationCategory = locationCategory;
        }

        public double getLocationPrice() {
            return locationPrice;
        }

        public void setLocationPrice(double locationPrice) {
            this.locationPrice = locationPrice;
        }
    }
}