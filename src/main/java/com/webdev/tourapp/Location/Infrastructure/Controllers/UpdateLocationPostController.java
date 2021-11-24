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
                request.getName(),
                request.getCoordinates(),
                request.getDescription(),
                request.getWebsiteUrl(),
                request.getCategory(),
                request.getPrice());
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
        private String name;
        private String coordinates;
        private String description;
        private String websiteUrl;
        private String category;
        private double price;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCoordinates() {
            return coordinates;
        }

        public void setCoordinates(String coordinates) {
            this.coordinates = coordinates;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getWebsiteUrl() {
            return websiteUrl;
        }

        public void setWebsiteUrl(String websiteUrl) {
            this.websiteUrl = websiteUrl;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }
}