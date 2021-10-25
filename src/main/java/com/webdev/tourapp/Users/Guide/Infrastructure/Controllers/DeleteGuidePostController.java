package com.webdev.tourapp.Users.Guide.Infrastructure.Controllers;


import com.webdev.tourapp.Users.Guide.Application.DeleteGuide.GuideDelete;
import com.webdev.tourapp.Users.Guide.Domain.Exceptions.NoGuideFound;
import com.webdev.tourapp.Users.User.Application.DeleteUser.UserDelete;
import com.webdev.tourapp.Users.User.Domain.Exceptions.NoUsersFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value="/Guide")
public class DeleteGuidePostController {
    @Autowired
    private GuideDelete delete;

    @GetMapping(value = "/")
    public ResponseEntity execute(@PathVariable("id") String id)
    {
        delete.execute(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
    @ExceptionHandler(NoUsersFound.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ResponseEntity<HashMap> handleGuideAlreadyExist(NoGuideFound exception) {
        HashMap<String, String> response = new HashMap<>() {{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

}