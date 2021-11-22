package com.webdev.tourapp.Cities.Infrastructure.Controllers;

import com.webdev.tourapp.Cities.Application.FindByCityName.CityNameFinder;
import com.webdev.tourapp.Cities.Application.FindByCityName.CityNameFinderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/City")
public class FindCityByNameGetController {
    @Autowired
    private CityNameFinder nameFinder;

    @GetMapping(value = "/cityName")
    @ResponseBody
    public ResponseEntity<List<HashMap<String, Object>>> execute(@RequestBody CityNameRequest request) {
        CityNameFinderResponse response = nameFinder.execute(request.getCityName());
        return ResponseEntity.status(HttpStatus.OK).body(response.response());
    }

    static class CityNameRequest {
        private String cityName;

        public CityNameRequest() {
        }

        public String getCityName() {
            return cityName;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }
    }

}