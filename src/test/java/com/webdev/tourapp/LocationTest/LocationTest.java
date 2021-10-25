package com.webdev.tourapp.LocationTest;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.webdev.tourapp.Location.Application.Create.LocationCreator;
import com.webdev.tourapp.Location.Domain.Location;
import com.webdev.tourapp.Location.Domain.Ports.LocationRepository;
import com.webdev.tourapp.Location.Domain.ValueObjects.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LocationTest {

    @Test
    void should_create_truck(){
        //Preparar el mock
        LocationRepository repository = mock(LocationRepository.class);

        //Caso de uso
        LocationCreator creator = new LocationCreator(repository);

        //Data falsa
        Location location = new Location(
                new LocationName("Chinca"),
                new LocationCoordinates("20D 30M 15G N"),
                new LocationDescription("Esto es una implementacion falsa"),
                new LocationWebsiteURL("www.location.test.co"),
                new LocationCategory("Lite"),
                new LocationPrice(25.000));

        //Ejecutar el caso de uso
        creator.execute(
                "Chinca",
                "20D 30M 15G N",
                "Esto es una implementacion falsa",
                "www.location.test.co",
                "Lite",
                25.000);

        //Ejecutar
        verify(repository, atLeastOnce()).save(location);
    }
}
