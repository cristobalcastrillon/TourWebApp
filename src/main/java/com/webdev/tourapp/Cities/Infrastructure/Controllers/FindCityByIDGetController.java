ackage com.webdev.tourapp.Cities.Infrastructure.Controllers;

import com.webdev.tourapp.Cities.Application.FinderByID.CityIDFinder;
import com.webdev.tourapp.Cities.Application.FinderByID.CityIDFinderResponse;
import com.webdev.tourapp.Cities.Domain.Exceptions.CityIDNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/City")
public class FindCityByIDGetController {

    @Autowired
    private CityIDFinder idFinder;

    @GetMapping(value = "/CityID")
    @ResponseBody
    public ResponseEntity<HashMap<String, Object>> execute(@RequestParam("cityID") String cityID) {
        CityIDFinderResponse response = idFinder.execute(cityID);
        return ResponseEntity.status(HttpStatus.OK).body(response.response());
    }

    @ExceptionHandler(CityIDNotFoundException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ResponseEntity<HashMap> handleCityIDNotFoundException(CityIDNotFoundException exception) {
        HashMap<String, String> response = new HashMap<>(){{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}