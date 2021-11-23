package com.webdev.tourapp.Cities.Infrastructure.Controllers;

import com.webdev.tourapp.Cities.Application.Update.CityUpdater;
import com.webdev.tourapp.Cities.Domain.Entities.LocationInCity;
import com.webdev.tourapp.Cities.Domain.Entities.TourInCity;
import com.webdev.tourapp.Cities.Domain.Exceptions.CityIDNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/City")
public class UpdateCityPostController {

    @Autowired
    private CityUpdater cityUpdater;

    @PostMapping(value="/Update")
    public ResponseEntity execute(@RequestParam("cityID") String cityID, CityRequest cityRequest) {
        this.cityUpdater.execute(cityID, cityRequest.getName(), cityRequest.getDefaultIATA(), cityRequest.getLocationsInCity(), cityRequest.getTours());
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @ExceptionHandler(CityIDNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<HashMap> handleCityIDNotFoundException(CityIDNotFoundException exception) {
        HashMap<String, String> response = new HashMap<>() {{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    static class CityRequest{
        private String name;
        private String defaultIATA;
        private Optional<List<LocationInCity>> locationsInCity;
        private Optional<List<TourInCity>> toursInCity;

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

        public Optional<List<LocationInCity>> getLocationsInCity() {
            return locationsInCity;
        }

        public void setLocationsInCity(Optional<List<LocationInCity>> locationsInCity) {
            this.locationsInCity = locationsInCity;
        }

        public Optional<List<TourInCity>> getTours() {
            return toursInCity;
        }

        public void setTours(Optional<List<TourInCity>> toursInCity) {
            this.toursInCity = toursInCity;
        }

        public CityRequest() {
        }
    }
}