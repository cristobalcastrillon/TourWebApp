package com.webdev.tourapp.Users.Guide.Infrastructure.Controllers;


import com.webdev.tourapp.Users.Guide.Application.FindGuideByID.FindGuideByID;
import com.webdev.tourapp.Users.Guide.Application.FindGuideByID.FindGuideByIDResponse;
import com.webdev.tourapp.Users.Guide.Domain.Exceptions.NoGuideFound;
import com.webdev.tourapp.Users.Guide.Domain.Guide;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value="/Guide")
public class FindGuideIDGetController
{
    @Autowired
    private FindGuideByID find;

    @GetMapping(value = "/id")
    public ResponseEntity<Object> execute(@PathVariable("id") String id)
    {
        Guide guide = find.execute(id);
        FindGuideByIDResponse response = new FindGuideByIDResponse(guide);
        return ResponseEntity.status(HttpStatus.OK).body(response.response());
    }
    @ExceptionHandler(NoGuideFound.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ResponseEntity<HashMap> handleGuideAlreadyExist(NoGuideFound exception) {
        HashMap<String, String> response = new HashMap<>() {{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
