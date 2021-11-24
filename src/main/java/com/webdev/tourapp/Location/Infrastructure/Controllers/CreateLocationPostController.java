package com.webdev.tourapp.Location.Infrastructure.Controllers;

import com.webdev.tourapp.Location.Application.All.LocationAllResponse;
import com.webdev.tourapp.Location.Application.Create.LocationCreator;
import com.webdev.tourapp.Location.Domain.Exceptions.LocationAlreadyExists;
import com.webdev.tourapp.Location.Domain.Exceptions.LocationNameNotValid;
import com.webdev.tourapp.Location.Domain.Exceptions.LocationPriceIsNegative;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value="/Location")
public class CreateLocationPostController {
    @Autowired
    private LocationCreator creator;

    @PostMapping(value = "/")
    public ResponseEntity execute(@RequestBody LocationRequest request) {
        this.creator.execute(
                request.getLocationID(),
                request.getName(),
                request.getDescription(),
                request.getCategory(),
                request.getCoordinates(),
                request.getWebsiteUrl(),
                request.getPrice());
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @ExceptionHandler(LocationAlreadyExists.class)
    @ResponseStatus(code = HttpStatus.CONFLICT)
    public ResponseEntity<HashMap> handleLocationAlreadyExists(LocationAlreadyExists exception) {
        HashMap<String, String> response = new HashMap<>(){{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @ExceptionHandler({LocationNameNotValid.class, LocationPriceIsNegative.class})
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ResponseEntity<HashMap> handleBadRequest(RuntimeException exception) {
        HashMap<String, String> response = new HashMap<>(){{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    static class LocationRequest {
        private String locationID;
        private String name;
        private String description;
        private String category;
        private String coordinates;
        private String websiteUrl;
        private double price;

        public String getLocationID() {
            return locationID;
        }

        public void setLocationID(String locationID) {
            this.locationID = locationID;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getCoordinates() {
            return coordinates;
        }

        public void setCoordinates(String coordinates) {
            this.coordinates = coordinates;
        }

        public String getWebsiteUrl() {
            return websiteUrl;
        }

        public void setWebsiteUrl(String websiteUrl) {
            this.websiteUrl = websiteUrl;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }

}