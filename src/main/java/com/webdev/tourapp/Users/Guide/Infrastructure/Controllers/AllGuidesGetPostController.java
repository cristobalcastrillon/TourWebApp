package com.webdev.tourapp.Users.Guide.Infrastructure.Controllers;


import com.webdev.tourapp.Users.Guide.Application.All.GuideAll;
import com.webdev.tourapp.Users.Guide.Application.All.GuideAllResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value="/Guide")
public class AllGuidesGetPostController {
    @Autowired
    private GuideAll all;

    @GetMapping(value = "/")
    public ResponseEntity<List<HashMap<String,Object>>> execute()
    {
        GuideAllResponse response = all.execute();
        return ResponseEntity.status(HttpStatus.OK).body(response.response());
    }
}
