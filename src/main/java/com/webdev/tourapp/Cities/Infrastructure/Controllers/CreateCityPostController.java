package com.webdev.tourapp.Cities.Infrastructure.Controllers;

import com.webdev.tourapp.Cities.Application.Create.CityCreator;
import com.webdev.tourapp.Cities.Domain.Entities.LocationsInCity;
import com.webdev.tourapp.Cities.Domain.Entities.ToursInCity;
import com.webdev.tourapp.Cities.Domain.Exceptions.CityAlreadyExists;
import com.webdev.tourapp.Cities.Domain.Exceptions.CityNameNotValid;
import com.webdev.tourapp.Cities.Domain.Exceptions.IataLenghtNotValid;
import com.webdev.tourapp.Cities.Domain.Exceptions.NumberInNameNoValid;
import com.webdev.tourapp.Tours.Tour.Domain.Exceptions.TourAlreadyExists;
import com.webdev.tourapp.Tours.Tour.Domain.Tour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/City")
public class CreateCityPostController {
    @Autowired
    private CityCreator creator;

    @PostMapping(value ="/" )
    public ResponseEntity execute(@RequestBody CityRequest request){

        this.creator.execute(request.getId(),request.getName(),request.getDefaultIATA(),request.getLocationsInCity(),request.getTours());
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @ExceptionHandler(CityAlreadyExists.class)
    @ResponseStatus(code = HttpStatus.CONFLICT)
    public ResponseEntity<HashMap> handleCityAlreadyExists(TourAlreadyExists exception){
        HashMap<String,String> response = new HashMap<>(){{

            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @ExceptionHandler({CityNameNotValid.class, IataLenghtNotValid.class, NumberInNameNoValid.class})
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ResponseEntity<HashMap> handleBadRequest(RuntimeException exception) {
        HashMap<String, String> response = new HashMap<>() {{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    static class CityRequest {

        public CityRequest() { }

        private String id;
        private String name;
        private String defaultIATA;
        private Optional<List<LocationsInCity>> locationsInCity;
        private Optional<List<ToursInCity>> tours;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDefaultIATA() {
            return defaultIATA;
        }

        public void setDefaultIATA(String defaultIATA) {
            this.defaultIATA = defaultIATA;
        }

        public Optional<List<LocationsInCity>> getLocationsInCity() {
            return locationsInCity;
        }

        public void setLocationsInCity(Optional<List<LocationsInCity>> locationsInCity) {
            this.locationsInCity = locationsInCity;
        }

        public Optional<List<ToursInCity>> getTours() {
            return tours;
        }

        public void setTours(Optional<List<ToursInCity>> tours) {
            this.tours = tours;
        }
    }
}