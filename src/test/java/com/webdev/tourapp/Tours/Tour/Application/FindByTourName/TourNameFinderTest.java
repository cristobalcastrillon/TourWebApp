package com.webdev.tourapp.Tours.Tour.Application.FindByTourName;

import com.webdev.tourapp.Tours.Tour.Application.FindByID.TourIDFinder;
import com.webdev.tourapp.Tours.Tour.Domain.Entities.Location;
import com.webdev.tourapp.Tours.Tour.Domain.Exceptions.NoToursFoundForSpecifiedTourName;
import com.webdev.tourapp.Tours.Tour.Domain.Exceptions.TourIDNotFound;
import com.webdev.tourapp.Tours.Tour.Domain.Ports.TourRepository;
import com.webdev.tourapp.Tours.Tour.Domain.Tour;
import com.webdev.tourapp.Tours.Tour.Domain.ValueObjects.TourID;
import com.webdev.tourapp.Tours.Tour.Domain.ValueObjects.TourName;
import com.webdev.tourapp.Tours.Tour.Domain.ValueObjects.TourPrice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

@SpringBootTest
public class TourNameFinderTest {

    ArrayList<Tour> tourList = new ArrayList<>();
    TourRepository repository;
    ArrayList<Location> locationList = new ArrayList<>();

    @BeforeEach
    void setup(){
        this.locationList.add(new Location("7cce613b-2b79-4a90-90bd-daf02c94f376",
                "Sagrada Familia",
                "41°24′13″N 2°10′27″E",
                "El Templo Expiatorio de la Sagrada Familia (en catalán, Temple Expiatori de la Sagrada Família), conocido simplemente como la Sagrada Familia, es una basílica católica de Barcelona (España), diseñada por el arquitecto Antoni Gaudí.",
                "Templo",
                "https://sagradafamilia.org/historia-del-temple",
                26.0));
        this.locationList.add(new Location("714af06b-f455-43f9-9a1d-9bef6e20ef02",
                "Casa Batlló",
                "41°23'17.99″ N 2°09'32.40″ E",
                "La Casa Batlló es un edificio obra del arquitecto Antoni Gaudí, máximo representante del modernismo catalán.",
                "Bien de Interés Cultural",
                "https://www.casabatllo.es/",
                35.0));

        Tour tour1 = new Tour(new TourID("d79d401a-d61a-42bc-81ec-0b5e0edb2e52"),
                new TourName("Tour Gaudí en Barcelona"),
                new TourPrice(200.0),
                this.locationList);

        Tour tour2 = new Tour(new TourID("3bde1548-624e-42ed-a17f-a1930627dbb6"),
                new TourName("Tour Gaudí"),
                new TourPrice(200.0),
                this.locationList);

        this.tourList.add(tour1);
        this.tourList.add(tour2);

        this.repository = mock(TourRepository.class);

        Mockito.when(repository.findByTourName(new TourName("Tour Gaudí en Barcelona"))).thenReturn(Optional.of(this.tourList));
    }

    @Test
    void should_not_find_tour(){

        TourNameFinder finder = new TourNameFinder(this.repository);

        Assertions.assertThrows(NoToursFoundForSpecifiedTourName.class, () -> {
            //TODO: ¡Regex en findByTourName!
            finder.execute("Tour en Barcelona");
        });
    }
}