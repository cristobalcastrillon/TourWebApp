package com.webdev.tourapp.Location.Infrastructure.Controllers;

import com.webdev.tourapp.Location.Application.FindByWebsiteURL.LocationWebSiteFinder;
import com.webdev.tourapp.Location.Application.FindByWebsiteURL.LocationWebSiteFinderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value="/Location")
public class FindByWebSiteURLGetController {

    @Autowired
    private LocationWebSiteFinder locationWebSiteFinder;

    @GetMapping(value ="/locationWebSite")
    @ResponseBody

    public ResponseEntity<List<HashMap<String,Object>>> execute(@RequestParam("website") String website) {
        LocationWebSiteFinderResponse response = locationWebSiteFinder.execute(website);
        return ResponseEntity.status(HttpStatus.OK).body(response.response());
    }
}