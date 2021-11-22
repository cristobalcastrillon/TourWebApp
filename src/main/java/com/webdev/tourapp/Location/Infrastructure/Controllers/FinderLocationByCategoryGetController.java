package com.webdev.tourapp.Location.Infrastructure.Controllers;

import com.webdev.tourapp.Location.Application.FindByCategory.LocationCategoryFinder;
import com.webdev.tourapp.Location.Application.FindByCategory.LocationCategoryFinderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value="/Location")
public class FinderLocationByCategoryGetController {

    @Autowired
    private LocationCategoryFinder locationCategoryFinder;


    @GetMapping(value ="/locationCategory")
    @ResponseBody
    public ResponseEntity<List<HashMap<String,Object>>> execute(@RequestParam("category") String category) {
        LocationCategoryFinderResponse response = locationCategoryFinder.execute(category);
        return ResponseEntity.status(HttpStatus.OK).body(response.response());
    }

}